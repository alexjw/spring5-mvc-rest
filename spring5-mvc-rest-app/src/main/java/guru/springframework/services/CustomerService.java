package guru.springframework.services;

import guru.springframework.api.v1.model.CustomerDTO;
import guru.springframework.domain.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService extends BaseServiceInterface<Customer, CustomerDTO> {

}
