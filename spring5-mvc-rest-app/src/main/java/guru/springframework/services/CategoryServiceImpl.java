package guru.springframework.services;

import guru.springframework.api.v1.mapper.SuperMapper;
import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.domain.Category;
import guru.springframework.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return repository.findById(id)
                .map(superMapper.categoryMapper::categoryToCategoryDTO)
                .map(categoryDTO -> {
                    //set API URL
                    categoryDTO.setUrl("/api/v1/categories/" + id);
                    return categoryDTO;
                })
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public CategoryDTO createNew(CategoryDTO dto) {
        Category customer = superMapper.categoryMapper.categoryDTOToCategory(dto);

        Category savedCategory = repository.save(customer);

        CategoryDTO returnDto = superMapper.categoryMapper.categoryToCategoryDTO(savedCategory);

        returnDto.setUrl("/api/v1/categories/" + savedCategory.getId());

        return returnDto;
    }

    @Override
    public CategoryDTO save(Long id, CategoryDTO dto) {
        Category category = superMapper.categoryMapper.categoryDTOToCategory(dto);
        category.setId(id);

        CategoryDTO result = superMapper.categoryMapper.categoryToCategoryDTO(save(id, category));
        result.setUrl("/api/v1/categories/" + id);
        return result;
    }

    @Override
    public CategoryDTO patch(Long id, CategoryDTO dto) {
        return null;
    }

    /*@Override
    public Category save(Long id, Category category) {
        return repository.save(category);
    }*/


}
