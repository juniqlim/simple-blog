package im.juniq.simpleblog.repository;

import im.juniq.simpleblog.model.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;

    @Test
    void test() {
        Post post = new Post(1L, "test title", "test content");
        Post savedPost = postRepository.save(post);

        Optional<Post> selectedPost = postRepository.findById(savedPost.getId());

        assertThat(savedPost.getId()).isEqualTo(selectedPost.get().getId());
        assertThat(savedPost.getTitle()).isEqualTo(selectedPost.get().getTitle());
    }
}