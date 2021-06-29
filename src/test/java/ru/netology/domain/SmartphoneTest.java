package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    Smartphone smartphone1 = new Smartphone(1, "Iphone19", 7000, "Apple");
    Smartphone smartphone2 = new Smartphone(1, "Nokia3300", 500, "Nokia");

    @Test
    void test() {
        Smartphone smartphone = new Smartphone();
    }

    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Smartphone smartphone = new Smartphone();
        smartphone.setId(1);
        smartphone.setName("Iphone19");
        smartphone.setPrice(150_000);
        smartphone.setManufacturer("Steve Jobs");

        assertEquals(1, smartphone.getId());
        assertEquals("Iphone19", smartphone.getName());
        assertEquals(150_000, smartphone.getPrice());
        assertEquals("Steve Jobs", smartphone.getManufacturer());
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
    @Test
    public void shouldMatch (){
        assertTrue(smartphone1.matches("le"));
    }

    @Test
    public void shouldNotMatch (){
        assertFalse(smartphone2.matches("ka"));
    }

}