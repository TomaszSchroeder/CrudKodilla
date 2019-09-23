package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTestSuite {

    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void mapToTaskTest() {

        // Given
        Task task = new Task(1L, "Test title", "Test content");
        TaskDto taskDto = new TaskDto(1L, "Test title", "Test content");

        // When
        Task mappedTask = taskMapper.mapToTask(taskDto);

        // Then
        assertEquals(task.getId(), mappedTask.getId());
        assertEquals(task.getTitle(), mappedTask.getTitle());
        assertEquals(task.getContent(), mappedTask.getContent());
    }

    @Test
    public void testMapToTaskDto() {
        // Given
        TaskDto taskDto = new TaskDto(1L, "Test title", "Test content");
        Task task = new Task(1L, "Test title", "Test content");

        // When
        TaskDto mappedTask = taskMapper.mapToTaskDto(task);

        // Then
        assertEquals(taskDto.getId(), mappedTask.getId());
        assertEquals(taskDto.getTitle(), mappedTask.getTitle());
        assertEquals(taskDto.getContent(), mappedTask.getContent());
    }

    @Test
    public void mapTaskDtoListTest() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Test title", "Test content");
        List<TaskDto> taskDtoList = Arrays.asList(taskDto);

        Task task = new Task(1L, "Test title", "Test content");
        List<Task> taskList = Arrays.asList(task);

        //When
        List<TaskDto> mappedList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertNotNull(mappedList);
        assertEquals(1, mappedList.size());

        mappedList.forEach(t -> {
            assertEquals(taskDto.getId(), t.getId());
            assertEquals(taskDto.getTitle(), t.getTitle());
            assertEquals(taskDto.getContent(),t.getContent());
        });
    }
}
