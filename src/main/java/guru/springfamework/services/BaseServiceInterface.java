package guru.springfamework.services;

import guru.springfamework.api.v1.model.BaseDTO;
import guru.springfamework.domain.BaseDomain;

import java.util.List;

public interface BaseServiceInterface<DOM extends BaseDomain, DTO extends BaseDTO> {

    public List<DTO> getAllDTO();

    public DTO getById(Long id);

    public DTO createNew(DTO dto);
}
