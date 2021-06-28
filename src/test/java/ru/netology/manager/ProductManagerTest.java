package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;



class ProductManagerTest {
    ProductRepository productRepository = new ProductRepository();
    ProductManager productManager = new ProductManager(productRepository);

    Book book1 = new Book(0, "Конные гусары", 500, "Соня Смитт");
    Book book2 = new Book(1, "Страж", 199, "Алексей Пехов");
    Smartphone smartphone1 = new Smartphone(2, "Iphone19", 99000, "Apple");
    Smartphone smartphone2 = new Smartphone(3, "Iphone15", 70200, "Apple");
    Smartphone smartphone3 = new Smartphone(3, "Sony21", 10200, "Сони");

    @Test
    void searchByMany() {
        productManager.addProduct(book1);
        productManager.addProduct(book2);
        productManager.addProduct(smartphone1);
        productManager.addProduct(smartphone2);
        productManager.addProduct(smartphone3);

        assertArrayEquals(new Product[]{book1,smartphone3}, productManager.searchBy("Со"));
    }

    @Test
    void searchByOneTrue() {
        productManager.addProduct(book1);

        assertArrayEquals(new Product[]{book1},productManager.searchBy("Со"));
    }

    @Test
    void searchByOneFalse() {
        productManager.addProduct(smartphone1);

        assertArrayEquals(new Product[]{},productManager.searchBy("Со"));
    }

    @Test
    void searchByZero() {
        assertArrayEquals(new Product[]{},productManager.searchBy("В"));
    }
}








//class ProductManagerTest {
//    ProductRepository repository = new ProductRepository();
//    ProductManager manager = new ProductManager(repository);
//
//    Book book1 = new Book(1, "ancient", 500, "Древний", "Найс");
//
//    Book book2 = new Book(2, "fantasy", 500, "Сиала", "Пехов");
//
//    Smartphone smartphone1 = new Smartphone(3, "AppleA40", 15990, "A40", "Найс");
//
//    Smartphone smartphone2 = new Smartphone(4, "samsungA21s", 16990, "A21s", "samsung");
//
//
//    @BeforeEach
//    void prepareManager() {
//        manager.addProduct(book1);
//        manager.addProduct(book2);
//        manager.addProduct(smartphone1);
//        manager.addProduct(smartphone2);
//    }
//
//
//    @Test
//    void searchByMany() {
//        manager.addProduct(book1);
//        manager.addProduct(book2);
//        manager.addProduct(smartphone1);
//        manager.addProduct(smartphone2);
//
//        assertArrayEquals(new Product[]{book1},manager.searchBy("Найс"));
//    }
//
//    @Test
//    void searchByOneTrue() {
//        manager.addProduct(book1);
//
//        assertArrayEquals(new Product[]{book1},manager.searchBy("На"));
//    }
//
//    @Test
//    void searchByOneFalse() {
//        manager.addProduct(book2);
//
//        assertArrayEquals(new Product[]{},manager.searchBy("Со"));
//    }
//
//    @Test
//    void searchByZero() {
//        assertArrayEquals(new Product[]{},manager.searchBy("В"));
//    }













//    @Test
//    public void shouldSave() {
//
//        manager.addProduct(book1);
//        Product[] actual = manager.getItems();
//        Product[] expected = new Product[]{
//                book1,
//                book2,
//                Smartphone1,
//                Smartphone2,
//                book1
//        };
//        assertArrayEquals(expected, actual);
//    }

//    @Test
//    public void shouldFindById() {
//        int idToFind = 4;
//        Product actual = manager.getRepository().findById(4);
//        Smartphone expected = Smartphone2;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldMatchesBookAuthor() {
//        Book book = book2;
//        boolean expected = manager.matches(book, "Пехов");
//
//        assertTrue(expected);
//    }
//
//    @Test
//    public void shouldMatchesBookName() {
//        Book book = book1;
//        boolean expected = manager.matches(book, "Д");
//
//        assertTrue(expected);
//    }
//
//    @Test
//    public void shouldMatchesSmartPhoneModel() {
//        Smartphone smartphone = Smartphone1;
//        boolean expected = manager.matches(smartphone, "A40");
//
//        assertTrue(expected);
//    }
//
//    @Test
//    public void shouldMatchesSmartphoneManufacturer() {
//        Smartphone smartphone = Smartphone1;
//        boolean expected = manager.matches(smartphone, "Apple");
//
//        assertFalse(expected);
//    }
//
//
//    @Test
//    public void shouldNotMatchesSmartphoneModel() {
//        Smartphone smartphone = Smartphone2;
//        boolean expected = manager.matches(smartphone, "A22s");
//
//        assertTrue(expected);
//    }
//
//    @Test
//    public void shouldMatchesSmartphoneManufacturer1() {
//        Smartphone smartphone = Smartphone1;
//        boolean expected = manager.matches(smartphone, "Apple");
//
//        assertTrue(expected);
//    }
//
//    @Test
//    public void shouldSearchByText() {
//        Product[] expect = new Product[]{Smartphone2, Smartphone1};
//        Product[] actual = manager.searchBy("A21");
//        System.out.println(actual);
//        assertArrayEquals(expect, actual);
//
//    }

