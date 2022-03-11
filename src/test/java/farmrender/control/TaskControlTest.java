package farmrender.control;

import farmrender.Main;
import farmrender.model.Task;
import farmrender.service.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * @author ArvikV
 * @version 1.0
 * @since 11.03.2022
 */
@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
@WebAppConfiguration
public class TaskControlTest {
    private Task task;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TaskService taskService;

    @Test
    @WithMockUser
    public void createPostForm() throws Exception {
        this.mockMvc.perform(get("/task-create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("tasksList/createTask"));
    }

    @Test
    public void givenIdTODeleteThenShouldDeleteThePost() {
        Task task = new Task(4L,  "postToDelete", "descOfPostToDelete", "RENDERING");
        taskService.savePost(task);
        taskService.deleteById(task.getId());
        Optional<Task> optional = taskService.findById(task.getId());
        Assertions.assertEquals(Optional.empty(), optional);
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(post("/task-create")
                        .param("name", "Пост"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Task> argument = ArgumentCaptor.forClass(Task.class);
        verify(taskService).savePost(argument.capture());
        assertThat(argument.getValue().getName(), is("Пост"));
    }

    @Test
    @WithMockUser
    public void saveAndUpdatePost() throws Exception {
        this.mockMvc.perform(post("/save")
                        .param("name", "ПровПост"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Task> argument = ArgumentCaptor.forClass(Task.class);
        verify(taskService).savePost(argument.capture());
        assertThat(argument.getValue().getName(), is("ПровПост"));
    }
}