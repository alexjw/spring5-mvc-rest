package guru.springfamework.api.v1.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class BaseDTO {

    private Long id;

}
