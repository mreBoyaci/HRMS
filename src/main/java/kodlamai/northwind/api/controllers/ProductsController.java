package kodlamai.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamai.northwind.business.abstracts.ProductService;
import kodlamai.northwind.core.utilities.results.DataResult;
import kodlamai.northwind.core.utilities.results.Result;
import kodlamai.northwind.entities.concretes.Product;

@RestController // sen bir controllersın demek.
@RequestMapping("/api/products") // eğer bana kodlama.io/api/products böyle bi adres üzerinden istek gelirse onu
									// karşılicak servis budur demek örnek.
public class ProductsController { // Dış dünyamızın sistemimizle iletişim kurduğu yer controllerdır.

	private ProductService productService;

	@Autowired // diyoki (ProductService productService) bana bu adam lazım diyor projeyi
				// tarıyor kim ProductManageri implements etmiş diyor ProductManagerı buluyor
				// newliyor geliyor productServiceye yerleştiriyor.(newleme işlemi yapıyor)
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall") // veri istedeğimiz zaman bunlar get request deniliyor bu yüzden getmapping
							// yapıyoruz.
	public DataResult<List<Product>> getAll() {
		return this.productService.getAll();

	}

	@PostMapping("/add") // @RequestBody hem istek yapıyor hemde budur diyor
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
	
	@GetMapping("/getByProductName")  // yapılan isten		requestBody gibi 
	public DataResult <Product> getByProductName(@RequestParam String productName){ // gönderilen
		return this.productService.getByProductName(productName);
		
	}
	
	@GetMapping("/getByProductNameAndCategory")
	public DataResult<Product> getByProductNameAndCategory(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
		
		return this.productService.getByProductNameAndCategory(productName, categoryId);
		
	}
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){	// arama kısmı burası 
		return this.productService.getByProductNameContains(productName);	
	}
	@GetMapping("/getAllByPage")
	DataResult<List<Product>>  getAll(int pageNo , int pageSize){
		return this.productService.getAll(pageNo,pageSize);	
				
	}
	@GetMapping("/getAllDESC")
	public DataResult<List<Product>> getAllSorted(){
		
		return this.productService.getAllSorted();
	}
	
	
	
	
	
	
	
	
	
	
	

}



















