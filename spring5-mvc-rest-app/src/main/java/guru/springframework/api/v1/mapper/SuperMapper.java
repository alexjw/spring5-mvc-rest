package guru.springframework.api.v1.mapper;

import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.api.v1.model.CustomerDTO;
import guru.springframework.domain.Category;
import guru.springframework.domain.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SuperMapper {

    public CustomerMapper customerMapper;

    public CategoryMapper categoryMapper;

    public VendorMapper vendorMapper;

    public SuperMapper() {
        this.customerMapper = CustomerMapper.INSTANCE;
        this.categoryMapper = CategoryMapper.INSTANCE;
        this.vendorMapper = VendorMapper.INSTANCE;
    }

    public SuperMapper(CustomerMapper customerMapper, CategoryMapper categoryMapper, VendorMapper vendorMapper) {
        this.customerMapper = customerMapper;
        this.categoryMapper = categoryMapper;
        this.vendorMapper = vendorMapper;
    }

    public List<CustomerDTO> convertCustomerDomainListToDTO(List<Customer> customers) {
        return customers.stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
    }

    public List<CategoryDTO> convertCategoryDomainListToDTO(List<Category> customers) {
        return customers.stream()
                .map(categoryMapper::categoryToCategoryDTO)
                .collect(Collectors.toList());
    }

}
