package com.jocelinlaroch08.inventorymanagement.repository;

import com.jocelinlaroch08.inventorymanagement.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
