package guru.springfamework.services;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService extends BaseService<Category, CategoryDTO> {

    CategoryDTO getByName(String name);

}
