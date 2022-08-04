package kodlamai.northwind.entities.concretes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity  // sen bir veri tabanı nesnesisin demek.
@Table(name = "products") // veritabanında hangi tabloya karşılık geleceğini belirtiriyoruz.
@AllArgsConstructor // tüm argümanları kullanarak bi tane constructer  ekle
@NoArgsConstructor	
public class Product {
	
	// @Column(name = "product_id") == bu alan veri tabanında hangi alana karşılık geliyor.
	// databasedeki ismi ile yazıyoruz.
	
	
		@Id // id alanın ne olduğunu söylememiz gerekiyor.(sorgular bu idye göre yapılandırılır.)
		@GeneratedValue(strategy = GenerationType.IDENTITY) // id nin otomatik mi manuel mi artıcağını söylüyoruz.(bizimkisi otomatik 1 er 1 er)		
		@Column(name = "product_id")  //hangi kolona karşılık geldiği
		private int id;
		
//		@Column(name = "category_id")
//		private int categoryId;
		
		@Column(name = "product_name")  
		private String productName;
		
		@Column(name = "unit_price")  
		private double unitPrice;
	
		@Column(name = "units_in_stock")  
		private short unitsInStock;
	
		@Column(name = "quantity_per_unit")  
		private String quantityPerUnit;
	
		@ManyToOne()	// ilişkili olan tabloyla ilişkisinin nasıl olduğunu belirtiyoruz
		@JoinColumn(name="category_id")
		private Category category;
}
















