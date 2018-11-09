package com.ddb.demo.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Neo4jApplication{
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Neo4jApplication.class, args);
		
	}

}
