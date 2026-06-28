package com.ecom.product_Catalog.config;

import com.ecom.product_Catalog.model.Product;
import com.ecom.product_Catalog.model.Category;
import com.ecom.product_Catalog.repositories.CategoryRepo;
import com.ecom.product_Catalog.repositories.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final CategoryRepo categoryRepo;
    private final ProductRepo productRepo;

    @Override
    public void run(String... args) throws Exception {
    productRepo.deleteAll();
    categoryRepo.deleteAll();
        Category electronics = new Category();
        electronics.setName("Electronics");

        Category fashion = new Category();
        fashion.setName("Fashion");

        Category books = new Category();
        books.setName("Books");

        Category home = new Category();
        home.setName("Home & Kitchen");

        categoryRepo.saveAll(List.of(
                electronics,
                fashion,
                books,
                home
        ));

        // Products

        Product p1 = new Product();
        p1.setName("Samsung Galaxy S25");
        p1.setDescription("Flagship Android smartphone with AI features.");
        p1.setImageUrl("https://picsum.photos/300?1");
        p1.setPrice(79999.0);
        p1.setCategory(electronics);

        Product p2 = new Product();
        p2.setName("Apple AirPods Pro");
        p2.setDescription("Wireless noise cancelling earbuds.");
        p2.setImageUrl("https://picsum.photos/300?2");
        p2.setPrice(24999.0);
        p2.setCategory(electronics);

        Product p3 = new Product();
        p3.setName("Men's Denim Jacket");
        p3.setDescription("Blue slim-fit denim jacket.");
        p3.setImageUrl("https://picsum.photos/300?3");
        p3.setPrice(2499.0);
        p3.setCategory(fashion);

        Product p4 = new Product();
        p4.setName("Women's Sneakers");
        p4.setDescription("Comfortable running shoes.");
        p4.setImageUrl("https://picsum.photos/300?4");
        p4.setPrice(3499.0);
        p4.setCategory(fashion);

        Product p5 = new Product();
        p5.setName("Atomic Habits");
        p5.setDescription("Best-selling self improvement book.");
        p5.setImageUrl("https://picsum.photos/300?5");
        p5.setPrice(499.0);
        p5.setCategory(books);

        Product p6 = new Product();
        p6.setName("Clean Code");
        p6.setDescription("Programming book by Robert C. Martin.");
        p6.setImageUrl("https://picsum.photos/300?6");
        p6.setPrice(699.0);
        p6.setCategory(books);

        Product p7 = new Product();
        p7.setName("Mixer Grinder");
        p7.setDescription("750W mixer grinder.");
        p7.setImageUrl("https://picsum.photos/300?7");
        p7.setPrice(3999.0);
        p7.setCategory(home);

        Product p8 = new Product();
        p8.setName("Non-stick Fry Pan");
        p8.setDescription("Premium non-stick frying pan.");
        p8.setImageUrl("https://picsum.photos/300?8");
        p8.setPrice(1299.0);
        p8.setCategory(home);

        productRepo.saveAll(List.of(
                p1, p2, p3, p4,
                p5, p6, p7, p8
        ));

    }
}
