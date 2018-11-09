package com.ddb.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.ddb.elasticsearch.model.Article;

public interface ElasticsearchDemoRepository extends ElasticsearchRepository<Article, Long>{

}
