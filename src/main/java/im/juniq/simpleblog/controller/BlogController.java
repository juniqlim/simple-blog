package im.juniq.simpleblog.controller;

import im.juniq.simpleblog.model.Category;
import im.juniq.simpleblog.model.Post;
import im.juniq.simpleblog.service.BlogService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping("/categorys")
    public List<Category> getCategorys() {
        return blogService.getCategoryAll();
    }

    @GetMapping("/category/{categoryId}/posts")
    public List<Post> getPosts(@PathVariable Long categoryId) {
        return blogService.getPosts(categoryId);
    }
}
