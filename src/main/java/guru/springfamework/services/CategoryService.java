package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.CategoryMapper;
import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService extends BaseServiceInterface<Category, CategoryDTO> {

    CategoryDTO getByName(String name);
    //CategoryDTO getCategoryByName(String name);

}
