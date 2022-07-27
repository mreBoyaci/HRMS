package kodlamai.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamai.northwind.business.abstracts.ProductService;
import kodlamai.northwind.dataAccess.abstracts.ProductDao;
import kodlamai.northwind.entities.concretes.Product;


@Service  // bu class projede servis görevi görücek diye springe bilgi veriyoruz.
public class ProductManager implements ProductService{  // Sen bir ProductService referansı tutan bir arkadaşsın

	private ProductDao productDao;
	
	@Autowired  // spring gidip arka planda buna karşılık gelebilcek projede bir sınıf üretiyor ve bunu veriyor.
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
		
	}


	@Override  //
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return this.productDao.findAll();
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
}
