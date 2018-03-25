package ru.dynamiclayoutapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 24.03.2018.
 */

public class ProductList {
    public List<Product> getProductList(int count, String prefix) {
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Product product = new Product();
            product.Name = String.format("Product %s.%d", prefix, i);
            product.Price = "5 345, 89";
            products.add(product);
        }
        return products;
    }
}
