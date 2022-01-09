package im.juniq.simpleblog.repository;

import im.juniq.simpleblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
