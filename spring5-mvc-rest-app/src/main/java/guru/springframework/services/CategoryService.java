package guru.springframework.services;

import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.domain.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService extends BaseServiceInterface<Category, CategoryDTO> {

    CategoryDTO getByName(String name);
    //CategoryDTO getCategoryByName(String name);

}
