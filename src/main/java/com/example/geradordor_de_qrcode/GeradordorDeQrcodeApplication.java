package com.example.geradordor_de_qrcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class GeradordorDeQrcodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeradordorDeQrcodeApplication.class, args);
    }

}
