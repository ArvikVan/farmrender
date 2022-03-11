package farmrender.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

/**
 * @author ArvikV
 * @version 1.0
 * @since 11.03.2022
 */
@Entity
@Table(name = "posts")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Calendar created;
    private String status;

    public Task() {
    }

    public Task(Long id, String name, String description, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public static Task of(String name) {
        Task task = new Task();
        task.name = name;
        return task;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Task task = (Task) o;
        return id == task.id
                && Objects.equals(name, task.name)
                && Objects.equals(description, task.description)
                && Objects.equals(created, task.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, created);
    }
}
