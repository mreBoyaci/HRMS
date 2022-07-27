package kodlamai.northwind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication

//@ComponentScan(basePackages = "kodlamai.northwind.ProductsController," + 
//"kodlamai.northwind.NorthwindApplication.service")

public class NorthwindApplication {

	// proje başlangıç dosyası 
	public static void main(String[] args) {
		SpringApplication.run(NorthwindApplication.class, args);
	}

}
