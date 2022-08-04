package kodlamai.northwind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2 // swaggerı başlatan anatasyon 
//@ComponentScan(basePackages = "kodlamai.northwind.ProductsController," + 
//"kodlamai.northwind.NorthwindApplication.service")

public class NorthwindApplication {

	// proje başlangıç dosyası 
	public static void main(String[] args) {
		SpringApplication.run(NorthwindApplication.class, args);
	}
	@Bean//java classı(normal classdan farkı yok)uygulama başladığı anda sprinbootumuz beanı gördüğü zaman bunu belleğe 
	// yerleştiriyor docker isimli nesne ile bizim controllerlarımızı ordakı bütün requesthandler ları buluyor ve bizim için dökümantasyon haline getiriyor 
    public Docket api() { //kodlamai.northwindi gez orda requesthandlerları bul onları dökümantasyona ekle // api bulucu 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("kodlamai.northwind"))              
//          .paths(PathSelectors.any())                          
          .build();                                           
    }

}