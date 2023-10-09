package org.example.controller;

import org.example.abstraction.sevice.TaskService;
import org.example.abstraction.sevice.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public record TaskController(
	TaskService taskService
) {
	@GetMapping("/getTask/{id}")
	public Mono<TaskService.TaskDto> findByid(@PathVariable Long id){
		return taskService.getById(id);
	}

	@PostMapping("/addTask")
	public Mono<Long> findById(@RequestBody TaskService.AddTaskDto addTaskDto) {return taskService.addTask(addTaskDto);}
}
