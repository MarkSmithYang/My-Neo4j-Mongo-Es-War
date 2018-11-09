package com.ddb.demo.neo4j.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ddb.demo.neo4j.common.DataInfo;
import com.ddb.demo.neo4j.exception.ParameterErrorException;
import com.ddb.demo.neo4j.model.Card;
import com.ddb.demo.neo4j.service.Neo4jService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("Neo4j的Demo")
@RestController
public class CardController {
	
	@Autowired
	private Neo4jService neo4jService;
	
	@ApiOperation("查询数据")
	@GetMapping("/getNeo4j")
	public DataInfo<Card> getNeo4j(@ApiParam(name="number",value="编号") @RequestParam(required=true) String number){
		if(StringUtils.isBlank(number)) {
			ParameterErrorException.message("编号不能为空");
		}
		Card result = neo4jService.findByNumber(number);
		return DataInfo.success(result);
	}
	
}
