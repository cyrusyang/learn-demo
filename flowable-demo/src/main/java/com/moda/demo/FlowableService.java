package com.moda.demo;

import org.flowable.bpmn.model.FlowElement;
import org.flowable.bpmn.model.MultiInstanceLoopCharacteristics;
import org.flowable.bpmn.model.UserTask;
import org.flowable.engine.*;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.util.CollectionUtils;

import java.util.*;


public class FlowableService {

    public static void main(String[] args) {
        ProcessEngine processEngine = Demo.init();
//        Demo.deploy(processEngine, "flows/采购流程.bpmn20.xml");
//        start(processEngine, "purchase:1:20003");
//        List<Task> tasks = taskQuery(processEngine);
//        complete(processEngine, tasks);
        queryFlowElements(processEngine, "purchase:1:20003");
    }

    public static ProcessEngine init(){
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://127.0.0.1:3307/flowable?characterEncoding=UTF-8")
                .setJdbcUsername("root")
                .setJdbcPassword("123456")
                .setJdbcDriver("com.mysql.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();
        return processEngine;
    }

    private static void start(ProcessEngine processEngine, String instanceId) {
        RuntimeService runtimeService = processEngine.getRuntimeService();
        Map<String, Object> variables = new HashMap<>();
        List<String> users = new ArrayList<>();
        users.add("jack");
        users.add("jony");
        users.add("anna");
        variables.put("purchaseManagers",users);
        ProcessInstance processInstance = runtimeService.startProcessInstanceById(instanceId, variables);
    }

    private static List<Process> queryFlowElements(ProcessEngine processEngine, String defId) {
//获取所有节点信息
        RepositoryService repositoryService = processEngine.getRepositoryService();
        List<Process> processes = repositoryService.getBpmnModel(defId).getProcesses();
        System.out.println("processes size:" + processes.size());
        for (Process process : processes) {
            Collection<FlowElement> flowElements = process.getFlowElements();
            if (!CollectionUtils.isEmpty(flowElements)) {
                for (FlowElement flowElement : flowElements) {
                    if (flowElement instanceof UserTask) {
                        MultiInstanceLoopCharacteristics loopCharacteristics = ((UserTask) flowElement).getLoopCharacteristics();
                        System.out.println(flowElement.getName()+":"+ flowElement.getName());
                    }
                }
            }
        }
        return processes;
    }

    public static List<Task> taskQuery(ProcessEngine processEngine){
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskAssignee("anna").list();
        System.out.println("You have " + tasks.size() + " tasks:");
        for (int i=0; i<tasks.size(); i++) {
            System.out.println((i+1) + ") " + tasks.get(i).getName());
        }
        return tasks;
    }

    public static void complete(ProcessEngine processEngine, List<Task> tasks) {
        if (CollectionUtils.isEmpty(tasks)) {
            return;
        }
        System.out.println("Which task would you like to complete?");
        Scanner scanner= new Scanner(System.in);
        int taskIndex = Integer.valueOf(scanner.nextLine());
        Task task = tasks.get(taskIndex - 1);
        Map<String, Object> map = new HashMap<>();
        map.put("approved", true);
        TaskService taskService = processEngine.getTaskService();
        taskService.complete(task.getId(), map);
    }
}
