package com.univ.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

/**
 * Spring Boot Multi Database Application!
 */
@SpringBootApplication
@EnableNeo4jRepositories
@EnableCassandraRepositories
public class AppBootStarter {
    public static void main(String[] args) {
        SpringApplication.run(AppBootStarter.class, args);
    }
}
