package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager products = new ProductManager(repository);
    Product product1 = new Book(11, "Стихотворения", 500, "Пушкин");
    Product product2 = new Book(12, "Рассказы", 300, "Чехов");
    Product product3 = new Book(13, "Стихотворения", 500, "Лермонтов");
    Product product4 = new Smartphone(21, "iPhone 13", 61_599, "Apple");
    Product product5 = new Smartphone(22, "iPhone 14", 132_399, "Apple");


    @BeforeEach
    public void setup() {
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
    }

    @Test
    public void shouldFindAll() {
        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = products.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor() {
        Product[] expected = {product1};
        Product[] actual = products.searchBy("Пушкин");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByFabricator() {
        Product[] expected = {product4, product5};
        Product[] actual = products.searchBy("Apple");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByNameBook() {
        Product[] expected = {product1, product3};
        Product[] actual = products.searchBy("Стихотворения");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByNameSmartphone() {
        Product[] expected = {product4};
        Product[] actual = products.searchBy("iPhone 13");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByNotExist() {
        Product[] expected = new Product[0];
        Product[] actual = products.searchBy("Тест");

        Assertions.assertArrayEquals(expected, actual);

    }


}
