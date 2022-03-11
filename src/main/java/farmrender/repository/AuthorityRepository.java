package farmrender.repository;

import farmrender.model.Authority;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ArvikV
 * @version 1.0
 * @since 11.03.2022
 */
public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
    Authority findByAuthority(String authority);


}
