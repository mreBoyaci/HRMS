package kodlamai.northwind.api.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamai.northwind.business.abstracts.ProductService;
import kodlamai.northwind.entities.concretes.Product;


@RestController  // sen bir controllersın demek.
@RequestMapping("/api/products")  // eğer bana  kodlama.io/api/products böyle bi adres üzerinden istek gelirse onu karşılicak servis budur demek örnek. 
public class ProductsController { // Dış dünyamızın sistemimizle iletişim kurduğu yer controllerdır.
	
	
	private ProductService productService;
	
	@Autowired // diyoki (ProductService productService) bana bu adam lazım diyor projeyi tarıyor  kim ProductManageri implements etmiş diyor ProductManagerı buluyor newliyor  geliyor productServiceye yerleştiriyor.(newleme işlemi yapıyor)
	public ProductsController(ProductService productService) {
	super();
	this.productService = productService;
}

	@GetMapping("/getall") // veri istedeğimiz zaman bunlar get request deniliyor bu yüzden getmapping yapıyoruz.
	public List<Product> getAll(){
		return this.productService.getAll();
	
	}

	
}
