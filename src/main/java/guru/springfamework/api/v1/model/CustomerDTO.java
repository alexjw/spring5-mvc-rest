package guru.springfamework.api.v1.model;

import lombok.Data;

@Data
public class CustomerDTO extends BaseDTO {

    private String firstName;
    private String lastName;

}
