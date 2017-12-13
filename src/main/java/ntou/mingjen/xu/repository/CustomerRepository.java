package ntou.mingjen.xu.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ntou.mingjen.xu.model.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
    
}
