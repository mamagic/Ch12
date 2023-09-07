package tacos;
import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.rest.core.annotation.RestResource;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Document
@RestResource(rel="tacos", path="tacos")
public class Taco {

  @Id
  @Indexed
  private String id;
  
  @NotNull
  @Size(min=5, message="Name must be at least 5 characters long")
  private String name;
  
  private Date createdAt = new Date();

  @Size(min=1, message="You must choose at least 1 ingredient")
  private List<Ingredient> ingredients;
}
