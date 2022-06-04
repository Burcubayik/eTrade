package eTrade.business.concretes;

import java.util.List;

import eTrade.business.abstracts.ProductService;
import eTrade.dataAccess.abstracts.ProductRepository;
import eTrade.entities.concretes.Product;

public class ProductManager implements ProductService {
	ProductRepository productRepository;
	
	public ProductManager(ProductRepository productRepository) {
		this.productRepository = productRepository;
		
	}

	@Override
	public void add(Product product) {
		if(!checkIfProductNameExist(product.getName()) && !checkProductUnitPrice(product) && countCategoryId(product) < 5) {
			productRepository.add(product);
			
		}
		
		else {
			System.out.println("Eklenemiyor: " + product.getName());
		}
		
		
	}

	@Override
	public void update(Product product) {
		productRepository.update(product);
		
	}

	@Override
	public void delete(Product product) {
		productRepository.delete(product);
		
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return productRepository.getAll();
	}

	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean checkIfProductNameExist(String productName) {
		boolean exist = false;
		for(Product product : productRepository.getAll() ) {
			if(product.getName()==productName) {
				exist = true;
			}
		}
		return exist;
		
	}
	
	private boolean checkProductUnitPrice(Product product) {
		boolean isSmall = false;
		
			if(product.getUnitPrice() <= 0) {
				isSmall = true;
			}
		return isSmall;
	}
	
	private int countCategoryId(Product product) {
		int count = 0;
		for(Product item : productRepository.getAll()) {
			if(item.getCategoryId() == product.getCategoryId()) {
			count++;
			}
		}
		return count;
	}

}
