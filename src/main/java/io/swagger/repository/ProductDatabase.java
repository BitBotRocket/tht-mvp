package io.swagger.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import io.swagger.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDatabase {

    private final AtomicLong counter = new AtomicLong(0);

    private Map<String, Product> database = new ConcurrentHashMap<>();

    private String KEY_FORMAT = "%d";

    public Product store(Product value) {

        final String key = value.getId();

        if (key != null) {
            database.put(key, value);
            return value;
        } else {
            value.setId(String.format(KEY_FORMAT, counter.incrementAndGet()));
            database.put(value.getId(), value);
            return value;
        }

    }

    public Product retrieve(String key) {
        if (key != null) {
            return database.get(key);
        } else {
            return null;
        }
    }

    public List<Product> retrieveAll() {
        final List<Product> products = new ArrayList<>();
        products.addAll(database.values());
        return products;
    }

    public void clear() {
        database.clear();
        counter.set(0);
    }
}
