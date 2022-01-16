package im.juniq.simpleblog.repository;

import im.juniq.simpleblog.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void save() {
        Category category = new Category("test_name");
        categoryRepository.save(category);
    }
}