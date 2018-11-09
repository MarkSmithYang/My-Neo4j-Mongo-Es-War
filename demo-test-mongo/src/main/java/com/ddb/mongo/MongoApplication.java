package com.ddb.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MongoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MongoApplication.class, args);
	}

}
