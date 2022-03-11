package farmrender.repository;

import farmrender.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ArvikV
 * @version 1.0
 * @since 11.03.2022
 */
@Repository
public interface PostRepository extends JpaRepository<Task, Long> {
}
