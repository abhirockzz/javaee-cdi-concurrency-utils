package com.wordpress.abhirockzz.cdi.concutils;

import com.wordpress.abhirockzz.cdi.concutils.pojo.TaskState;
import com.wordpress.abhirockzz.cdi.concutils.pojo.Task;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.inject.Singleton;

@Singleton
@Lock(LockType.READ) //change the default concurrency semantic
public class TaskStore {

    private Map<String, Task> idToTaskMapping = new ConcurrentHashMap<>();

    public void addTask(String taskid, Task task) {
        idToTaskMapping.put(taskid, task);
    }

    public Task getTask(String taskid){
        return idToTaskMapping.get(taskid);
    }
    public void markComplete(String taskid){
        Task task = idToTaskMapping.get(taskid);
        task.setEnd(new Date());
        task.setState(TaskState.COMPLETED);
    }
    
     public void markFailed(String taskid){
        Task task = idToTaskMapping.get(taskid);
        task.setEnd(new Date());
        task.setState(TaskState.FAILED);
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        for(Task task : idToTaskMapping.values()){
            tasks.add(task);
        }
        return tasks;

    }

    public TaskState getStatusForTask(String taskid) {
        return idToTaskMapping.get(taskid).getState();
    }
}
