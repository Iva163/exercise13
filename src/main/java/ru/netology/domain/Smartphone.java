package ru.netology.domain;

public class Smartphone extends Product {
    private String fabricator;

    public Smartphone(int id, String name, int price, String fabricator) {
        super(id, name, price);
        this.fabricator = fabricator;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) { // вызов метода matches в версии описанной в Product
            return true;
        }
        if (fabricator.contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
