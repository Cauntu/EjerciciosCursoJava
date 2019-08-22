package com.es.eoi.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.es.eoi.interfaces.Alumno;

@Configuration
@ComponentScan(basePackageClasses = Alumno.class)
public class Config {

}
