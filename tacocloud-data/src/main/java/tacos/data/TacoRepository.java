package tacos.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.Optional;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import tacos.Taco;

//@CrossOrigin(origins="*") // 추가됨
public interface TacoRepository 
         extends ReactiveCrudRepository<Taco, String> {
}
