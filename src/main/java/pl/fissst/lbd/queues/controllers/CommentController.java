package pl.fissst.lbd.queues.controllers;

import org.springframework.web.bind.annotation.*;
import pl.fissst.lbd.queues.dto.CommentDto;
import pl.fissst.lbd.queues.services.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //POST /comment - COMMENT_CREATED
    @PostMapping
    public void CreateComment(@RequestBody CommentDto commentDto){
        commentService.CreateComment(commentDto);
    }
    //PUT /comment - COMMENT_UPDATED
    @PutMapping
    public void UpdateComment(@RequestBody CommentDto commentDto,@RequestParam("id") Long id){
        commentService.UpdateComment(commentDto,id);
    }
    //DELETE /comment - COMMENT_DELETED
    @DeleteMapping
    public void DeleteComment(@RequestParam("id") Long id){
        commentService.DeleteComment(id);
    }

}
