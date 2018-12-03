package com.dhht.process.service.Impl;

import com.dhht.process.service.ResumeService;
import org.springframework.stereotype.Service;


@Service("ResumeService")
public class resumeServiceImp implements ResumeService {

    @Override
    public void storeResume() {
        System.out.println("任务已经执行.....................................");
    }
}
