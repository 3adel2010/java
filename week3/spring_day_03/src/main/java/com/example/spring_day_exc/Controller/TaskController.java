package com.example.spring_day_exc.Controller;

import com.example.spring_day_exc.Api.ApiResponse;
import com.example.spring_day_exc.Pojo.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController
{
    private ArrayList<Task> tasks = new ArrayList<>();

    @PostMapping("/add")
    public ApiResponse addTask(@RequestBody Task task)
    {
        tasks.add(task);
        return new ApiResponse("Task added");
    }

@GetMapping("/get")
    public ArrayList<Task> getTasks()
    {
        return tasks;
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateTask(@PathVariable int index,@RequestBody Task task)
    {
        tasks.set(index,task);
        return new ApiResponse("Task updated");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteTask(@PathVariable int index)
    {
        tasks.remove(index);
        return new ApiResponse("Task removed");
    }

    @PutMapping("/changeStatus/{index}")
    public ApiResponse changeStatus(@PathVariable int index)
    {
        Task task1 = tasks.get(index);
        if (task1.getStatus().equals("Done"))
            task1.setStatus("Not done!");
        else
            task1.setStatus("Done!");
        return new ApiResponse("Task status changed!");
    }

    @GetMapping("/search")
    public ApiResponse searchTask(@RequestBody String tit)
    {
        String newTit = tit.replaceAll("(\")","").replaceAll("\"","");
        String[] tt = new String[tasks.size()];
        for (int i = 0; i < tt.length; i++)
        {
             tt[i] = tasks.get(i).getTitle();
        }
        for(String t :tt){
            if(t.equals(newTit)){
                return new ApiResponse("It's there");
            }
        }
        return new ApiResponse("It's not there");
    }
}
