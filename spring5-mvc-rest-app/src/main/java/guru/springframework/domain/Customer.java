package guru.springframework.domain;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Customer extends BaseDomain {

    private String firstName;
    private String lastName;

}
