package farmrender.repository;

import farmrender.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ArvikV
 * @version 1.0
 * @since 11.03.2022
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByUsername(String name);
}
