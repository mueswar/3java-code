package com.db_mongo;

import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.lang.Nullable;
import org.springframework.transaction.TransactionException;

import com.mongodb.TransactionOptions;

public class MongoTransactionManager1 extends MongoTransactionManager{
	
	public MongoTransactionManager1(MongoDatabaseFactory dbFactory) {
		super(dbFactory, null);
	}
	
	public MongoTransactionManager1(MongoDatabaseFactory dbFactory, @Nullable TransactionOptions options) {

		super(dbFactory, options);
	}
	
	@Override
	protected Object doGetTransaction() throws TransactionException {
		return super.doGetTransaction();
	}

}
