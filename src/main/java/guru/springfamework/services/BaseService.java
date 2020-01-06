package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.SuperMapper;
import guru.springfamework.api.v1.model.BaseDTO;
import guru.springfamework.domain.BaseDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

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

}
