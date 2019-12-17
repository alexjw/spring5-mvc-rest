package guru.springfamework.services;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;

import java.util.List;

public interface CategoryService extends BaseService<Category, CategoryDTO> {

    CategoryDTO getByName(String name);

}
