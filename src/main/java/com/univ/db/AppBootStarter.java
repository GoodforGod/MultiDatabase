package com.univ.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Spring Boot Multi Database Application!
 */
@SpringBootApplication
@EnableNeo4jRepositories
@EnableCassandraRepositories
@EnableScheduling
public class AppBootStarter {
    public static void main(String[] args) {
        SpringApplication.run(AppBootStarter.class, args);
    }
}
