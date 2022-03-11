package farmrender.control;

import farmrender.service.TaskService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ArvikV
 * @version 1.0
 * @since 11.03.2022
 */
@Controller
public class IndexControl {
    private final TaskService posts;

    public IndexControl(TaskService posts) {
        this.posts = posts;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("posts", posts.getAll());
        return "index";
    }
}
