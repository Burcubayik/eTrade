package eTrade.dataAccess.concretes.jdbcImpls;

import java.util.ArrayList;
import java.util.List;

import eTrade.dataAccess.abstracts.ProductRepository;
import eTrade.entities.concretes.Product;

public class JdbcProductRepository implements ProductRepository{
	List<Product> products;
	
	public JdbcProductRepository() {
		products = new ArrayList<Product>();
	}

	@Override
	public void add(Product product) {
		products.add(product);
		
	}

	@Override
	public void update(Product product) {
		Product updatedProduct = getById(product.getId());
		updatedProduct.setName(product.getName());
		updatedProduct.setCategoryId(product.getCategoryId());
		updatedProduct.setDescription(product.getDescription());
		updatedProduct.setUnitPrice(product.getUnitPrice());
		
	}

	@Override
	public void delete(Product product) {
		products.remove(product);
		
	}

	@Override
	public List<Product> getAll() {
		return products;
	}

	@Override
	public Product getById(int id) {
		Product findToProduct = null;
	for(Product product : products) {
		if(product.getId() == id) {
			findToProduct = product;
		}
	}

	return findToProduct;
		
	}

}
