package com.codekul.spring5Apr.config;


import com.codekul.spring5Apr.beanscope.Car;
import com.codekul.spring5Apr.beanscope.Vehicle;
import com.codekul.spring5Apr.di.Student;
import com.codekul.spring5Apr.di.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(" com.codekul.spring5Apr.ioc")

public class AppConfig {

    @Bean
    //@Scope(value = "singleton")
    public Vehicle getVehicle(){
        return new Vehicle();
    }
    @Bean
    @Scope(value = "prototype")
    public Car getCar(){

        return new Car();
    }
    @Bean
    public Teacher getTeacher(){
        return new Teacher();
    }




}
