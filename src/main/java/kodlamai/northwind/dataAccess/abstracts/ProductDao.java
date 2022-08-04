package kodlamai.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamai.northwind.entities.concretes.Product;

								//  jparepository ile entitiyi tutuyoruz
public interface ProductDao extends JpaRepository<Product,Integer>{    // interface interface'yi extends edebilir.	
	// tabloya bakıyor getBy a göre where koşulu oluştuuryor kendisi jparepo yapıyor
	
	
	Product getByProductName(String productName);   // select * from products where product_name = emre
	
				//1. kolon       2. kolon
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);  // select * from products where product_name = emre  and category_id = 1

				//1. kolon       2. kolon
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId); // select * from products where category_id in(1,2,3,4)
				// isimlendirme kuralına uyman yeterli
	
	List<Product> getByCategoryIn(List<Integer>categories); 
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	
		// veritabaını query yazarken unut
		//  hangi entityden  hangi alan     parametrem 
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")  // select * from products where product_name = bisey and category_id = bisey  
	List<Product> getByNameAndCategory(String productName, int categoryId);
}
