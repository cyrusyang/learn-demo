package com.moda.demo;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RuntimeService;

public class ApplyRoomDemo {
    public static void main(String[] args) {
        ProcessEngine processEngine = Demo.init();
//        Demo.deploy(processEngine, "");
        start(processEngine);

    }

    private static void start(ProcessEngine processEngine){
        RuntimeService runtimeService = processEngine.getRuntimeService();
    }
}
