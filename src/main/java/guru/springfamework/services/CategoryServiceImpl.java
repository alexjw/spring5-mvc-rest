package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.CategoryMapper;
import guru.springfamework.api.v1.mapper.SuperMapper;
import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
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
        return repository.findById(id)
                .map(superMapper.categoryMapper::categoryToCategoryDTO)
                .map(categoryDTO -> {
                    //set API URL
                    categoryDTO.setUrl("/api/v1/category/" + id);
                    return categoryDTO;
                })
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public CategoryDTO createNew(CategoryDTO dto) {
        Category customer = superMapper.categoryMapper.categoryDTOToCategory(dto);

        Category savedCategory = repository.save(customer);

        CategoryDTO returnDto = superMapper.categoryMapper.categoryToCategoryDTO(savedCategory);

        returnDto.setUrl("/api/v1/category/" + savedCategory.getId());

        return returnDto;
    }

    @Override
    public CategoryDTO save(Long id, CategoryDTO dto) {
        Category category = superMapper.categoryMapper.categoryDTOToCategory(dto);
        category.setId(id);

        CategoryDTO result = superMapper.categoryMapper.categoryToCategoryDTO(save(id, category));
        result.setUrl("/api/v1/category/" + id);
        return result;
    }

    /*@Override
    public Category save(Long id, Category category) {
        return repository.save(category);
    }*/


}
