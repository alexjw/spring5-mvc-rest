package guru.springfamework.domain;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Vendor extends BaseDomain {

    String name;

}
