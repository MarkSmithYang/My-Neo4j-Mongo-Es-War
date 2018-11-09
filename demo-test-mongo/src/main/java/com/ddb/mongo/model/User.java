package com.ddb.mongo.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection="user")
public class User implements Serializable{
	private static final long serialVersionUID = 2935480448657050049L;

	@Id
	private String id;
	
	@NotBlank(message="姓名不能为空")
	@ApiModelProperty("姓名")
	private String name;
	
	@ApiModelProperty("年龄")
	private Integer age;
	
	@ApiModelProperty("住址")
	private String address;
	
	@Field(value="school",order=1)//order是排序,-1倒叙
	@ApiModelProperty("学校")
	private String schools;

	public User() {
	}

	public User(String id, String name, Integer age, String address, String schools) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.schools = schools;
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", age=" + age +
				", address='" + address + '\'' +
				", schools='" + schools + '\'' +
				'}';
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSchools() {
		return schools;
	}

	public void setSchools(String schools) {
		this.schools = schools;
	}
}
