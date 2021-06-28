package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    void test() {
        Smartphone smartphone = new Smartphone();
    }

    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Smartphone smartphone = new Smartphone();
        smartphone.setId(1);
        smartphone.setName("Новинка2021");
        smartphone.setPrice(150_000);
        smartphone.setManufacturer("Steve Jobs");
    }

    @Test
    void shouldCastFromBaseClass() {
        Product product = new Smartphone();

        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
        }
    }

    @Test
    public void shouldNotCastToDifferentClass() {
        Product product = new Smartphone();

        if (product instanceof Book) {
            Book book = (Book) product;
            book.setName("Хроника Сиалы");
        } else {
            System.out.println("Not found");
        }
}

}