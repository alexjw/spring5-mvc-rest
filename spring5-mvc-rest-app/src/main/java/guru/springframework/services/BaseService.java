package guru.springframework.services;

import guru.springframework.api.v1.mapper.SuperMapper;
import guru.springframework.api.v1.model.BaseDTO;
import guru.springframework.domain.BaseDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BaseService<DOM extends BaseDomain, DTO extends BaseDTO, REP extends JpaRepository<DOM, Long>> {

    public BaseService(REP repository, SuperMapper superMapper) {
        this.repository = repository;
        this.superMapper = superMapper;
    }

    REP repository;

    SuperMapper superMapper;

    List<DOM> getAllDomain() {
        return repository.findAll();
    }

    public DOM getDomainById(Long id) {
        return repository.findById(id).orElse(null);
    }

    abstract List<DTO> getAllDTO();

    public DOM save(Long id, DOM dom) {
        return repository.save(dom);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
