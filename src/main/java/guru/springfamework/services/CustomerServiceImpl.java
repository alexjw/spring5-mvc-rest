package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.SuperMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl extends BaseService<Customer, CustomerDTO, CustomerRepository> implements CustomerService {

    public CustomerServiceImpl(CustomerRepository repository, SuperMapper superMapper) {
        super(repository, superMapper);
    }

    @Override
    public List<CustomerDTO> getAllDTO() {
        return superMapper.convertCustomerDomainListToDTO(getAllDomain());
    }

    @Override
    public CustomerDTO getById(Long id) {
        return superMapper.customerMapper.customerToCustomerDTO(getDomainById(id));
    }

    @Override
    public CustomerDTO createNew(CustomerDTO customerDTO) {

        Customer customer = superMapper.customerMapper.customerDTOToCustomer(customerDTO);

        Customer savedCustomer = repository.save(customer);

        CustomerDTO returnDto = superMapper.customerMapper.customerToCustomerDTO(savedCustomer);

        returnDto.setUrl("/api/v1/customer/" + savedCustomer.getId());

        return returnDto;
    }

}
