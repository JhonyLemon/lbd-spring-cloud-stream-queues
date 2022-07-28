package pl.fissst.lbd.queues.controllers;

import org.springframework.web.bind.annotation.*;
import pl.fissst.lbd.queues.dto.ArticleDto;
import pl.fissst.lbd.queues.services.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    //POST /article - ARTICLE_CREATED
    @PostMapping
    public void CreateArticle(@RequestBody ArticleDto articleDto){
        articleService.CreateArticle(articleDto);
    }
    //PUT /article - ARTICLE_UPDATED
    @PutMapping
    public void UpdateArticle(@RequestBody ArticleDto articleDto,@RequestParam("id") Long id){
        articleService.UpdateArticle(articleDto,id);
    }

}
