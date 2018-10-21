package sngo4.com.sbelasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import sngo4.com.sbelasticsearch.entities.Customer;
import sngo4.com.sbelasticsearch.repository.CustomerRepository;

@SpringBootApplication
public class SbelasticsearchApplication {

	public static void main(String[] args) {

	    ApplicationContext context = SpringApplication.run(SbelasticsearchApplication.class, args);
	    CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
	    
	    System.out.println("---------- Demo  insert ----------------");
	    Customer customer = new Customer();
	    customer.setName("sena");
	    customer.setAddress("ha noi");
	    customerRepository.save(customer);
	    Customer customer2 = new Customer();
	    customer2.setId("1");
	    customer2.setName("kai");
	    customer2.setAddress("london");
	    customerRepository.save(customer2);
	    System.out.println("saved!");
	    
	    System.out.println("---------- Demo  findAll ----------------");
	    customerRepository.findAll().forEach(c -> System.out.println(c));
	    System.out.println("\n---------- Demo  find name = 'sena' ----------------");
	    customerRepository.findByName("sena").forEach(c -> System.out.println(c));
	    System.out.println("\n---------- Demo  delete id = '1' ----------------");
	    Customer customerDelete = customerRepository.findById("1").orElse(null);
	    if (customerDelete != null) {
	      customerRepository.delete(customerDelete);
	    }
	    System.out.println("Deleted!");
	    System.out.println("\n---------- Demo  findAll after delete ----------------");
	    customerRepository.findAll().forEach(c -> System.out.println(c));

	}
}
