package tacos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Order implements Serializable {
  private static final long serialVersionUID = 1L;
  
  @Id
  private String id;
  
  private Date placedAt = new Date();
  
  // 추후, Lazy 로딩시 문제가 될 수 있음
  // 직렬화시 제외하기 위해 사용한,
  // @JsonIgnore이 문제가 될 수 있음.
  //@JsonIgnore
  private User user;
  
  private String deliveryName;
  
  private String deliveryStreet;
  
  private String deliveryCity;
  
  private String deliveryState;
  
  private String deliveryZip;

  private String ccNumber;
  
  private String ccExpiration;

  private String ccCVV;

  private List<Taco> tacos = new ArrayList<>();
  
  public void addDesign(Taco design) {
    this.tacos.add(design);
  }

}
