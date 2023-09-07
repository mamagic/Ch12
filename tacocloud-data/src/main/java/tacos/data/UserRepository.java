package tacos.data;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import tacos.User;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, String> {

  Mono<User> findByUsername(String username);
}
