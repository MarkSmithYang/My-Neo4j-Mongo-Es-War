package com.ddb.elasticsearch.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ddb.elasticsearch.common.DataInfo;
import com.ddb.elasticsearch.model.Article;
import com.ddb.elasticsearch.model.Author;
import com.ddb.elasticsearch.model.Tutorial;
import com.ddb.elasticsearch.service.ElasticsearchService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("elasticsearch的demo测试")
@RestController
public class ElasticsearchController {

	@Autowired
	private ElasticsearchService elasticsearchService;

	@GetMapping("/add")
	public void testSaveArticleIndex() {
		Author author = new Author();
		author.setId(1L);
		author.setAuthorName("tianshouzhi");
		author.setRemark("java developer");

		Tutorial tutorial = new Tutorial();
		tutorial.setId(1L);
		tutorial.setTutorialName("elastic search");

		Article article = new Article();
		article.setId(1L);
		article.setTitle("springboot integreate elasticsearch");
		article.setAbstracts("springboot integreate elasticsearch is very easy");
		article.setTutorial(tutorial);
		article.setAuthor(author);
		article.setContent("elasticsearch based on lucene," + "spring-data-elastichsearch based on elaticsearch"
				+ ",this tutorial tell you how to integrete springboot with spring-data-elasticsearch");
		article.setPostTime(new Date());
		article.setClickCount(1L);

		elasticsearchService.save(article);
	}

	@GetMapping("/query")
	public DataInfo<List<Article>> testSearch() {
		String queryString = "springboot";// 搜索关键字
		List<Article> result = elasticsearchService.search(queryString);
		return DataInfo.success(result);
	}

	//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	
	@GetMapping("/saveTest")
	public DataInfo<String> saveTest() {
		elasticsearchService.saveTest();
		return DataInfo.success("ok");
	}

	@ApiOperation("根据搜索关键词查询数据")
	@GetMapping("/queryTest")
	public DataInfo<List<Article>> queryTest(@ApiParam(name="keyword",value="搜索关键词",required=true) @RequestParam(required=true) String keyword) {
		List<Article> result = elasticsearchService.queryTest(keyword);
		return DataInfo.success(result);
	}
	
	//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	
	//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&新大陆新大陆新大陆&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	
	@ApiOperation("新大陆查询")
	@GetMapping("/findQuery")
	public DataInfo<List<Article>> findQuery(@ApiParam(name="keyword",value="搜索关键词",required=true) @RequestParam(required=true) String keyword) {
		List<Article> result = elasticsearchService.findQuery(keyword);
		return DataInfo.success(result);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&新大陆新大陆新大陆&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
}
