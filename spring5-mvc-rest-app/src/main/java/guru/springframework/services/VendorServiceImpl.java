package guru.springframework.services;

import guru.springframework.api.v1.mapper.SuperMapper;
import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.domain.Vendor;
import guru.springframework.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl extends BaseService<Vendor, VendorDTO, VendorRepository> implements VendorService {

    public VendorServiceImpl(VendorRepository repository, SuperMapper superMapper) {
        super(repository, superMapper);
    }

    @Override
    public List<VendorDTO> getAllDTO() {
        return null;
    }

    @Override
    public VendorDTO getById(Long id) {
        return null;
    }

    @Override
    public VendorDTO createNew(VendorDTO dto) {
        return null;
    }

    @Override
    public VendorDTO save(Long id, VendorDTO dto) {
        return null;
    }

    @Override
    public VendorDTO patch(Long id, VendorDTO dto) {
        return null;
    }

}
