package com.ddb.demo.neo4j.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import com.ddb.demo.neo4j.model.Card;

public interface CardRepository extends GraphRepository<Card>{

	@Query("MATCH (n:Card) WHERE n.number = { num}  with n match p=(n)-[]-(m) return p,ID(n)")
	public Card findByNum( @Param("num") String number);
	
	public Card findByNumber( String number);

	@Query(" MATCH p=(n)-[o:DD]->(m) return n ")
	public List<Card> findList();

}
