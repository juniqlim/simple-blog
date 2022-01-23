package im.juniq.simpleblog.repository;

import im.juniq.simpleblog.model.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;

    @Test
    @Transactional
    void 저장후_id로_조회() {
        Post post = new Post(1L, "test title", "test content");
        Post savedPost = postRepository.save(post);

        Optional<Post> selectedPost = postRepository.findById(savedPost.getId());

        assertThat(savedPost.getId()).isEqualTo(selectedPost.get().getId());
        assertThat(savedPost.getTitle()).isEqualTo(selectedPost.get().getTitle());
    }

    @Test
    @Transactional
    void 저장후_categoryId로_조회() {
        Post post1 = new Post(1L, "test title", "test content");
        Post post2 = new Post(1L, "test title2", "test content2");
        postRepository.save(post1);
        postRepository.save(post2);

        List<Post> posts = postRepository.findByCategoryId(1L);

        assertThat(posts.size()).isEqualTo(2);
    }
}