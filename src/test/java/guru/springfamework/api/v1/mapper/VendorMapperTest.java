package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.domain.Vendor;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendorMapperTest {

    public static final String NAME = "A vendor";
    VendorMapper vendorMapper = VendorMapper.INSTANCE;

    @Test
    public void customerToCustomerDTO() {
        //given
        Vendor vendor = new Vendor();
        vendor.setId(1l);
        vendor.setName(NAME);

        //when
        VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);

        //then
        assertEquals(NAME, vendorDTO.getName());
        assertEquals(1, (long)vendorDTO.getId());
    }

    @Test
    public void customerDTOToCustomer() {

        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setId(1l);
        vendorDTO.setName(NAME);

        Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);

        assertEquals(NAME, vendor.getName());
        assertEquals(1, (long)vendor.getId());

    }

}