package service;

import Model.Product;

import java.util.*;

public class ProductServiceImpl implements ProductService {

    private static Map<Integer, Product> productMap = new HashMap<Integer, Product>();

    static {
        productMap.put(1, new Product(1, "Iphone", 1000, "Made in Chine", "Apple"));
        productMap.put(2, new Product(2, "Macbook", 1500, "Made in VietNam", "Apple"));
        productMap.put(3, new Product(3, "Galaxy", 1200, "Made in USA", "Samsung"));
        productMap.put(4, new Product(4, "Dell", 800, "Made in Thailand", "USA"));
        productMap.put(5, new Product(5, "Thinkpad", 900, "Made in Chine", "England"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Integer, Product> entry : productMap.entrySet()) {
            if (entry.getValue().getName().contains(name)) {
                productList.add(entry.getValue());
            }
        }
        return productList;
    }
}
//    Set<Integer> set = map.keySet();
//        for (Integer key : set) {
//                System.out.println(key + " " + map.get(key));
//                }