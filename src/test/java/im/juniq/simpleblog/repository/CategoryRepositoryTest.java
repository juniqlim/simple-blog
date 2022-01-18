package im.juniq.simpleblog.repository;

import im.juniq.simpleblog.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void 저장후_조회() {
        Category category = new Category("test_name");
        Category savedCategory = categoryRepository.save(category);

        Optional<Category> selectedCategory = categoryRepository.findById(savedCategory.getId());

        assertThat(savedCategory.getId()).isEqualTo(selectedCategory.get().getId());
        assertThat(savedCategory.getName()).isEqualTo(selectedCategory.get().getName());
    }
}
