package com.dhht.process.controller;

import com.dhht.process.service.ResumeService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/process")
@RestController
public class ProcessController {

    @Autowired
    ResumeService resumeService;
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    @RequestMapping("/test")
    public String testProcess(){
        Map<String, Object> variables = new HashMap<>();
        variables.put("applicantName", "John Doe");
        variables.put("email", "john.doe@activiti.com");
        variables.put("phoneNumber", "123456789");
        runtimeService.startProcessInstanceByKey("myProcess", variables);
        return "成功";
    }

}
