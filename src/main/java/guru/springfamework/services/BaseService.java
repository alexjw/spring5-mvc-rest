package guru.springfamework.services;

import guru.springfamework.api.v1.model.BaseDTO;
import guru.springfamework.domain.BaseDomain;

import java.util.List;

public interface BaseService<X extends BaseDomain, Y extends BaseDTO> {


    List<Y> getAll();

}
