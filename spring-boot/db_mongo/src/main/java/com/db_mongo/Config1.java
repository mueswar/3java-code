package com.db_mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;

@Configuration
public class Config1 {
	@Bean
	MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
	    return new MongoTransactionManager1(dbFactory);
	}
}
