package guru.springframework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class BaseDTO {

    @ApiModelProperty(value = "This is the id")
    private Long id;

    @JsonProperty("url")
    private String url;

}
