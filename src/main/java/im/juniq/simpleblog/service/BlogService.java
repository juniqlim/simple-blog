package im.juniq.simpleblog.service;

import im.juniq.simpleblog.model.Category;
import im.juniq.simpleblog.model.Post;
import im.juniq.simpleblog.repository.CategoryRepository;
import im.juniq.simpleblog.repository.PostRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final CategoryRepository categoryRepository;
    private final PostRepository postRepository;

    public List<Category> getCategoryAll() {
        return categoryRepository.findAll();
    }

    public List<Post> getPostAll() {
        return postRepository.findAll();
    }

    public List<Post> getPosts(Long categoryId) {
        return postRepository.findByCategoryId(categoryId);
    }
}
