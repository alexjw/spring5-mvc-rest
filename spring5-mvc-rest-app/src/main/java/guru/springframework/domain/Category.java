package guru.springframework.domain;

import lombok.Data;

import javax.persistence.Entity;

/**
 * Created by jt on 9/24/17.
 */
@Data
@Entity
public class Category extends BaseDomain{

    private String name;

}
