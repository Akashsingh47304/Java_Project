package com.akash.resumebuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class Mongotest implements CommandLineRunner {
    private final MongoTemplate mongoTemplate;

    public Mongotest(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) {
        System.out.println("DATABASE NAME = " + mongoTemplate.getDb().getName());

    }
}
