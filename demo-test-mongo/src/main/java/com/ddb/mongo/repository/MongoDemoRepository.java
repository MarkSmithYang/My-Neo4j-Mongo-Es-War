package com.ddb.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ddb.mongo.model.User;

public interface MongoDemoRepository extends MongoRepository<User, String>{

	public List<User> findByNameLike(String name);

	@Query(value="{age:21}",fields="{name:1,age:1,schools:1}")
	public List<User> query(String name);


}
