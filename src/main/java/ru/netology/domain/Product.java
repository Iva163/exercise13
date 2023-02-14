package ru.netology.domain;

public class Product {
    protected int id;
    protected String name;
    protected int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }


    public boolean matches(String search) {
        if (name.contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
