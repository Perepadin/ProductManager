package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    Book book1 = new Book(1, "Сиала", 700, "Пехов");
    Book book2 = new Book(1, "Грон", 500, "Злотников");

    @Test
    void test() {
        Book book = new Book();
    }

    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Book book = new Book();
        book.setId(1);
        book.setName("Страж");
        book.setPrice(150);
        book.setBookAuthor("Алекей Пехов");

        assertEquals(1, book.getId());
        assertEquals("Страж", book.getName());
        assertEquals(150, book.getPrice());
        assertEquals("Алекей Пехов", book.getBookAuthor());
    }

    @Test
    void shouldCastFromBaseClass() {
        Product product = new Book();

        if (product instanceof Book) {
            Book book = (Book) product;

        }
    }

    @Test
    public void shouldNotCastToDifferentClass() {
        Product product = new Book();

        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
        } else {
            System.out.println("Not found");
        }
    }

    @Test
    public void shouldMatch (){
        assertTrue(book1.matches("ла"));
    }

    @Test
    public void shouldNotMatch (){
        assertFalse(book2.matches("зла"));
    }

}