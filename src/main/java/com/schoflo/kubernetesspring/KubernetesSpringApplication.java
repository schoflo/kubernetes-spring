package com.schoflo.kubernetesspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class KubernetesSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(KubernetesSpringApplication.class, args);
    }

}
