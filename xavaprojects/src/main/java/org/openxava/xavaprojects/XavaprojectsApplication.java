package org.openxava.xavaprojects;

import org.openxava.spring.OpenXavaApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XavaprojectsApplication extends OpenXavaApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(XavaprojectsApplication.class, args);
    }

}
