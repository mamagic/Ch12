package tacos;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Document
public class Ingredient {
	
  private static final long serialVersionUID = 1L;

  @Id
  private final String id;
  private final String name;
  private final Type type;

  @PersistenceConstructor
  public Ingredient(String id, String name, Type type){
    this.id = id;
    this.name = name;
    this.type = type;
  }
  public static enum Type {
    WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
  }

}
