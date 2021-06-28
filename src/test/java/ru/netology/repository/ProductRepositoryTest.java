package ru.netology.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

class ProductRepositoryTest {

        private ProductRepository repository = new ProductRepository();
        private Book fantasy = new Book(2,"Хроники Сиалы",500, "Алексей Пехов");
        private Smartphone phone = new Smartphone(2, "История успеха", 150_000, "Steve Jobs");

        @Test
        void  shouldSaveOneItem() {
            repository.save(fantasy);
            repository.save(phone);

            Product[] expected = new Product[]{fantasy, phone};
            Product[] actual = repository.findAll();

            assertArrayEquals(expected, actual);
        }
}