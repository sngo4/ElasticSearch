package sngo4.com.sbelasticsearch.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import sngo4.com.sbelasticsearch.entities.Customer;

/*
 * ElasticsearchRepository giống với JpaRepository (database sql)
 *  hay MongoRepository (database mongodb)
 *   nó cũng định nghĩa sẵn các method như findAll, findById, remove, save… 
 *   và cũng hỗ trợ cả Query Creation
 */
public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {
	
	List<Customer> findByName(String name);

}
