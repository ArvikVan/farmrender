package farmrender.control;

import farmrender.model.Task;
import farmrender.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ArvikV
 * @version 1.0
 * @since 11.03.2022
 * работаем через сервисный слой
 */
@Controller
public class TaskControl {
    private final TaskService posts;

    @Autowired
    public TaskControl(TaskService posts) {
        this.posts = posts;
    }

    /**
     * отсылка на страницу с формой создания поста в маппинге указатель на  value='/task-create жсп страницы
     * @param task пост
     * @return идем на страниу креатепост
     */
    @GetMapping("/task-create")
    public String createPostForm(Task task) {
        return "tasksList/createTask";
    }

    /**
     * создаем пост
     * @param task пост
     * @return на выходе созданный пост
     */
    @PostMapping("/task-create")
    public String createPost(Task task) {
        posts.savePost(task);
        return "redirect:/";
    }

    /**
     * Deleting
     * @param id byId
     * @return return to main page
     */
    @GetMapping("/task-delete")
    public String deletePost(@RequestParam("id") Long id) {
        posts.deleteById(id);
        return "redirect:/";
    }

    /**
     * Обновляем
     * @param task пост для обновы
     * @return на выходе обнова
     */
    @PostMapping("/save")
    public String savePost(@ModelAttribute Task task) {
        posts.savePost(task);
        return "redirect:/";
    }
}