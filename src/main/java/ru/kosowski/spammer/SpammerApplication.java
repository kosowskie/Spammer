package ru.kosowski.spammer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class SpammerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpammerApplication.class, args);
    }
}