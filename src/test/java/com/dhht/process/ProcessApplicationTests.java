package com.dhht.process;

import com.dhht.process.service.ResumeService;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProcessApplication.class)
public class ProcessApplicationTests {


    @Autowired
    ResumeService resumeService;
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    @Test
    public void TestStartProcess() {
        Map<String, Object> variables = new HashMap<>();
        variables.put("applicantName", "John Doe");
        variables.put("email", "john.doe@activiti.com");
        variables.put("phoneNumber", "123456789");
        runtimeService.startProcessInstanceByKey("myProcess", variables);
    }

//    @Test
//    public void TestStartProcess() {
//        System.out.println("Start.........");
//        ProcessInstance pi = runtimeService.startProcessInstanceByKey("myProcess", "1");
//        System.out.println("流程启动成功，流程id:"+pi.getId());
//    }

    @Test
    public void findTasksByUserId() {
        String userId ="dulingjiang";
        List<Task> resultTask = taskService.createTaskQuery().processDefinitionKey("myProcess").taskCandidateOrAssigned(userId).list();
        System.out.println("任务列表："+resultTask);
    }

}
