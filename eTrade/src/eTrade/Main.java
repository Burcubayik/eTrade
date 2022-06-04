package eTrade;

import eTrade.business.abstracts.ProductService;
import eTrade.business.concretes.ProductManager;
import eTrade.dataAccess.concretes.hibernateImpls.HibernateProductRepository;
import eTrade.entities.concretes.Product;

public class Main {

	public static void main(String[] args) {
		ProductService productService = new ProductManager(new HibernateProductRepository());

		Product product1 = new Product(1, "Bilgisayar", 12000, "Asus", 1);
		Product product2 = new Product(2, "Telefon", 8000, "Huawei", 1);
		Product product3 = new Product(3, "Televizyon", 11000, "Beko", 1);
		Product product4 = new Product(4, "Tuşlu Telefon", 3000, "Nokia", 1);
		Product product5 = new Product(5, "Monitor", 12000, "LG", 1);
		Product product6 = new Product(6, "Ayakkabı", 500, "Nike", 2);
		Product product7 = new Product(4, "TTelefon", 3000, "Nokia", 1);

		productService.add(product1);
		productService.add(product2);
		productService.add(product3);
		productService.add(product4);
		productService.add(product5);
		productService.add(product6);
		productService.update(product7);

		productService.delete(product2);

		for (Product product : productService.getAll()) {
			System.out.println(product.getName());
		}

	}

}
