package xyz.streetscout;

import org.springframework.boot.SpringApplication;

public class TestStreetScoutApplication {

    public static void main(String[] args) {
        SpringApplication.from(StreetScoutApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
