package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();
    Product product1 = new Book(11, "Стихотворения", 500, "Пушкин");
    Product product2 = new Book(12, "Рассказы", 300, "Чехов");
    Product product3 = new Book(13, "Стихотворения", 500, "Лермонтов");
    Product product4 = new Smartphone(21, "iPhone 13", 61_599, "Apple");
    Product product5 = new Smartphone(22, "iPhone 14", 132_399, "Apple");

    @BeforeEach
    public void setup() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);
        repository.save(product5);

    }


    @Test
    public void shouldRemoveById() {

        repository.removeById(product4.getId());

        Product[] expected = {product1, product2, product3, product5};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveByIdNotFoundException() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(25);
        });
    }

    @Test
    public void shouldSaveAlreadyExistsException() {
        Product product = new Smartphone(22, "iPhone 14", 132_399, "Apple");
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repository.save(product);
        });
    }


}
