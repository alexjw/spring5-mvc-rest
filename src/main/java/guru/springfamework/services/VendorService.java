package guru.springfamework.services;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.domain.Vendor;
import org.springframework.stereotype.Service;

@Service
public interface VendorService extends BaseServiceInterface<Vendor, VendorDTO> {

}
