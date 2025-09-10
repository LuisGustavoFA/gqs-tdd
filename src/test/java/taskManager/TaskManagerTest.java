package taskManager;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class TaskManagerTest {
    @Test
    public void shouldGetAllTasks() {
        //Arrange
        TaskService mockTaskService = mock(TaskService.class);

        List<Task> sampleTask = new ArrayList<>();
        sampleTask.add(new Task(1, "task 1", "description task 1"));
        sampleTask.add(new Task(2, "task 2", "description task 2"));

        when(mockTaskService.getAllTasks()).thenReturn(sampleTask);
        TaskManager taskManager = new TaskManager(mockTaskService);

        //Action
        List<Task> tasks = taskManager.getAllTasks();

        //Assert
        verify(mockTaskService).getAllTasks();
    }
}
