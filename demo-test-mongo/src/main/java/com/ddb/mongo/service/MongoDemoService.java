package com.ddb.mongo.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.ddb.mongo.model.User;
import com.ddb.mongo.repository.MongoDemoRepository;
import com.mongodb.WriteResult;

@Service
public class MongoDemoService {

	@Autowired
	private MongoDemoRepository mongoDemoRepository;
	@Autowired
	private MongoTemplate mongoTemplate;

	public List<User> query(String name) {
		User user2 = new User("1", "小刘", 19, "贵阳", "r");
		mongoTemplate.save(user2);

		// 查詢
		Query query = new Query(Criteria.where("name").is("小刘").and("age").is(19));
		List<User> find = mongoTemplate.find(query, User.class);
		find.forEach(user -> System.err.println(user.getName() + ":::" + user.getAge()));
		// 修改
		Update update = new Update().set("school", "贵州大学");
		Query query2 = new Query(Criteria.where("name").is("小刘"));
		mongoTemplate.updateFirst(query2, update, User.class);
		// 增加
		mongoDemoRepository.save(new User("3", "小马", 20, "上海", "浙江大学"));
		mongoDemoRepository.save(new User("2", "小赵", 21, "北京", "北京大学"));

		List<User> findAll = mongoTemplate.findAll(User.class, "user");
		System.err.println(findAll.toString());

		List<User> results = mongoDemoRepository.findByNameLike(name);
		System.err.println("results:" + results);

		List<User> users = mongoDemoRepository.query(name);

		return findAll;
	}

}
