package com.codekul.spring5Apr.ioc;

import org.springframework.stereotype.Component;

@Component
public class StudentImpl implements SchoolService{
    @Override
    public void doWork() {
        System.out.println("in Student impl");
    }
}
