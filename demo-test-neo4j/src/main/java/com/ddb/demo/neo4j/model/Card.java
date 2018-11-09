package com.ddb.demo.neo4j.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NodeEntity//表明该类是一个Neo4j支持的节点实体类
@ApiModel("Neo4j的Demo实体")
public class Card {

	@GraphId
	private Long id;
	private Long ccv;
	private String number;
	private String date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCcv() {
		return ccv;
	}

	public void setCcv(Long ccv) {
		this.ccv = ccv;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
