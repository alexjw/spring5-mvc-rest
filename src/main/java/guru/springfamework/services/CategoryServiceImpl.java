package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.CategoryMapper;
import guru.springfamework.api.v1.mapper.SuperMapper;
import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;
import guru.springfamework.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl extends BaseService<Category, CategoryDTO, CategoryRepository> implements CategoryService {

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, SuperMapper superMapper) {
        super(categoryRepository, superMapper);
    }

    @Override
    public CategoryDTO getByName(String name) {
        return superMapper.categoryMapper.categoryToCategoryDTO(repository.findByNameIgnoreCase(name));
    }

    @Override
    public List<CategoryDTO> getAllDTO() {
        return superMapper.convertCategoryDomainListToDTO(getAllDomain());
    }

    @Override
    public CategoryDTO getById(Long id) {
        return superMapper.categoryMapper.categoryToCategoryDTO(getDomainById(id));
    }
}
