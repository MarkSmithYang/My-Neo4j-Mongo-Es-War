package com.ddb.mongo.controller;

import java.util.List;

import javax.validation.Valid;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ddb.mongo.common.DataInfo;
import com.ddb.mongo.model.User;
import com.ddb.mongo.service.MongoDemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api("mongodb数据库使用demo")
@RestController
public class MongoDemoController {

	@Autowired
	private MongoDemoService mongoDemoService;

	@ApiOperation("查询数据")
	@GetMapping("query")
	@ApiImplicitParams({@ApiImplicitParam(name="name",value="姓名",paramType="query",dataType="string")})
	public DataInfo<List<User>> query(
			@Valid @NotBlank(message = "姓名不能为空") @RequestParam String name) {
		List<User> result = mongoDemoService.query(name);
		return DataInfo.success(result);
	}
}
