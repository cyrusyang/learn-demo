package com.moda.demo;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class PurchaseDemo {

    public static void main(String[] args) {
        ProcessEngine processEngine = Demo.init();
//        Demo.deploy(processEngine, "flows/采购流程.bpmn20.xml");
//        start(processEngine, "purchase:1:20003");
        List<Task> tasks = taskQuery(processEngine);
        complete(processEngine, tasks);
    }

    private static void start(ProcessEngine processEngine, String instanceId) {
        RuntimeService runtimeService = processEngine.getRuntimeService();
        Map<String, Object> variables = new HashMap<>();
        List<String> users = new ArrayList<>();
        users.add("jack");
        users.add("jony");
        users.add("anna");
        variables.put("purchaseManagers",users);
        runtimeService.startProcessInstanceById(instanceId, variables);
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
