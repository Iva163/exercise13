package ru.netology.manager;

import ru.netology.domain.Product;

public class ProductRepository {

    private Product[] products = new Product[0];

    public Product[] findAll() {
        return products;
    }

    public void save(Product product) {
        int id = product.getId();
        for (Product prod : products) {
            if (prod.getId() == id) {
                throw new AlreadyExistsException(
                        "Element with id product: " + id + " already exist"
                );
            }
        }

        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        }

        Product[] tmp = new Product[products.length - 1];
        int copyIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyIndex] = product;
                copyIndex++;
            }
        }
        products = tmp;
    }


}
