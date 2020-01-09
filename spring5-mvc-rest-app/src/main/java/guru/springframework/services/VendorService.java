package guru.springframework.services;

import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.domain.Vendor;
import org.springframework.stereotype.Service;

@Service
public interface VendorService extends BaseServiceInterface<Vendor, VendorDTO> {

}
