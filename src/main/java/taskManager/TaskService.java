package taskManager;

import java.util.List;

public interface TaskService {
    public List<Task> getAllTasks();
    public void addTask(Task task);
}
