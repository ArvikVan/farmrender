package farmrender.service;

import farmrender.model.Task;
import farmrender.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author ArvikV
 * @version 1.0
 * @since 11.03.2022
 * Сервисный слой
 * Все методы стандартные, проблема была с крудрепой и жпарепой, так и не
 * понял в чем разница, в обоих методы одинаковые
 */
@Service
@Transactional
public class TaskService {
    private static final Logger LOG = LoggerFactory.getLogger(TaskService.class);
    private final Timer timer = new Timer();

    private final PostRepository posts;

    @Autowired
    public TaskService(PostRepository posts) {
        this.posts = posts;
    }

    public List<Task> getAll() {
        List<Task> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }

    public Task savePost(Task task) {
        task.setCreated(Calendar.getInstance());
        task.setStatus("RENDERING");
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                task.setId(task.getId());
                task.setStatus("COMPLETE");
                posts.save(task);
            }
        };
        timer.schedule(timerTask, (long) (60000 + (Math.random() * 240000)));
        return posts.save(task);
    }

    public void deleteById(Long id) {
           posts.deleteById(id);
    }

    public Optional<Task> findById(Long id) {
        return posts.findById(id);
    }

}
