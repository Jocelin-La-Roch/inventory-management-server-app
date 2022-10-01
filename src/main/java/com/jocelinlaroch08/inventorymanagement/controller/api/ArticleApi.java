package com.jocelinlaroch08.inventorymanagement.controller.api;

import com.jocelinlaroch08.inventorymanagement.dto.ArticleDto;
import com.jocelinlaroch08.inventorymanagement.utils.Utils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ArticleApi {

    @PostMapping(value = Utils.APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save(@RequestBody ArticleDto articleDto);

    @GetMapping(value = Utils.APP_ROOT+"/articles/{articleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable("articleId") Integer id);

    @GetMapping(value = Utils.APP_ROOT+"/articles/{articleCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCode(@PathVariable("articleCode") String code);

    @GetMapping(value = Utils.APP_ROOT+"/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();

    @DeleteMapping(value = Utils.APP_ROOT+"/articles/delete/{articleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("articleId") Integer id);

}
