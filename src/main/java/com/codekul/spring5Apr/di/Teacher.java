package com.codekul.spring5Apr.di;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ToString
public class Teacher {
    public Teacher(){
        System.out.println("in Teacher");
    }
    public void doWork(){
        System.out.println("do work");
    }
}
