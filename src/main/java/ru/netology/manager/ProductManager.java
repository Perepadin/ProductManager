package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static java.lang.System.arraycopy;

public class ProductManager {

    public ProductManager(ProductRepository repository, Product[] items) {
        this.repository = repository;
        this.items = items;
    }

    public ProductManager(ProductRepository repository) {
    }

    public ProductRepository getRepository() {
        return repository;
    }

    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    public Product[] getItems() {
        return items;
    }

    public void setItems(Product[] items) {
        this.items = items;
    }


    private ProductRepository repository = new ProductRepository();
    private Product[] items = new Product[0];

    public void addProduct(Product item) {
        repository.save(item);
    }

//    private Product[] actionSearchBy(Product product) {
//        Product[] result = new Product[0];
//        Product[] tmp = new Product[result.length + 1];
//        // используйте System.arraycopy, чтобы скопировать всё из result в tmp
//        tmp[tmp.length - 1] = product;
//        arraycopy(tmp, 0, result, 0, result.length);
//        return result;
//    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                // используйте System.arraycopy, чтобы скопировать всё из result в tmp
                System.arraycopy(result, 0, tmp, 0, result.length);
                // сделано
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }


    public boolean matches(Product product, String search) {
        if (product instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            if (((Book) product).getBookAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            return product.getName().contains(search);
        }
        if (product instanceof Smartphone) { // если в параметре product лежит объект класса Smartphone
            Smartphone smartphone = (Smartphone) product; // положем его в переменную типа Smartphone чтобы пользоваться методами класса Smartphone
            if (((Smartphone) product).getManufacturer().contains(search)) { // проверим есть ли поисковое слово в данных об производителе
                return true;
            }
            return product.getName().contains(search);
        }
        return false;
    }
}
