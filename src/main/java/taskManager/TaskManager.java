package taskManager;

import java.util.List;

public class TaskManager {
    private TaskService taskService;

    public TaskManager(TaskService taskService) {
        this.taskService = taskService;
    }

    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
}
