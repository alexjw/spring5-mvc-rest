package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.SuperMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Category;
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
        return repository.findById(id)
                .map(superMapper.customerMapper::customerToCustomerDTO)
                .map(customerDTO -> {
                    //set API URL
                    customerDTO.setUrl("/api/v1/customers/" + id);
                    return customerDTO;
                })
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public CustomerDTO createNew(CustomerDTO customerDTO) {

        Customer customer = superMapper.customerMapper.customerDTOToCustomer(customerDTO);

        Customer savedCustomer = repository.save(customer);

        CustomerDTO returnDto = superMapper.customerMapper.customerToCustomerDTO(savedCustomer);

        returnDto.setUrl("/api/v1/customers/" + savedCustomer.getId());

        return returnDto;
    }

    @Override
    public CustomerDTO save(Long id, CustomerDTO dto) {
        Customer customer = superMapper.customerMapper.customerDTOToCustomer(dto);
        customer.setId(id);

        CustomerDTO result = superMapper.customerMapper.customerToCustomerDTO(save(id, customer));
        result.setUrl("/api/v1/customers/" + id);
        return result;
    }

    @Override
    public CustomerDTO patch(Long id, CustomerDTO dto) {
        return repository.findById(id).map(customer -> {

            if(dto.getFirstName() != null){
                customer.setFirstName(dto.getFirstName());
            }

            if(dto.getLastName() != null){
                customer.setLastName(dto.getLastName());
            }

            CustomerDTO customerDTO = superMapper.customerMapper.customerToCustomerDTO(repository.save(customer));
            customerDTO.setUrl("/api/v1/customers/" + id);
            return customerDTO;
        }).orElseThrow(RuntimeException::new);
    }

    /*@Override
    public Customer save(Long id, Customer customer) {
        return null;
    }*/

}
