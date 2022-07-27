package kodlamai.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamai.northwind.entities.concretes.Product;


public interface ProductDao extends JpaRepository<Product,Integer>{    // interface interface'yi extends edebilir.	
	
	

}
