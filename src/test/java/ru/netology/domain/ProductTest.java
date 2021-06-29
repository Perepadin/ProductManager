package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product1 = new Product(1, "Золото", 700);
    Product product2 = new Product(2, "Платина", 500);

    @Test

    public void shouldUseEquals() {
        Product product1 = new Product(1, "Серебро", 500);
        Product product2 = new Product(1, "Серебро", 500);
        assertEquals(product1, product2);
    }

    @Test
    public void shouldMatch (){
        assertTrue(product1.matches("ло"));
    }

    @Test
    public void shouldNotMatch (){
        assertFalse(product1.matches("да"));
    }
}