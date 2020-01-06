package guru.springfamework.services;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService extends BaseServiceInterface<Customer, CustomerDTO> {

}
