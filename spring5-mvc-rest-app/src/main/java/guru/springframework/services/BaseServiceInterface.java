package guru.springframework.services;

import guru.springframework.api.v1.model.BaseDTO;
import guru.springframework.domain.BaseDomain;

import java.util.List;

public interface BaseServiceInterface<DOM extends BaseDomain, DTO extends BaseDTO> {

    public List<DTO> getAllDTO();

    public DTO getById(Long id);

    public DTO createNew(DTO dto);

    public DTO save(Long id, DTO dto);

    public DOM save(Long id, DOM dom);

    public DTO patch(Long id, DTO dto);

    public void delete(Long id);
}
