package com.wordpress.abhirockzz.cdi.concutils;

import com.wordpress.abhirockzz.cdi.concutils.pojo.TaskState;
import com.wordpress.abhirockzz.cdi.concutils.pojo.Task;
import java.util.Date;
import java.util.Random;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class BackgroundTask implements Runnable {

    String taskid;

    public void setTaskID(String taskid) {
        this.taskid = taskid;
    }

    @Inject
    TaskStore ts;

    @Override
    public void run() {
        try {
            System.out.println("Running in thread " + Thread.currentThread().getName());
            Task task = new Task(taskid, TaskState.IN_PROGRESS, new Date(), null);
            ts.addTask(taskid, task);
            long sleep = new Random().nextInt(10000) + 5000;
            System.out.println("sleeping for " + sleep);
            Thread.sleep(sleep);
            System.out.println("Task " + taskid + " completed ......");
            ts.markComplete(taskid);
        } catch (Exception e) {
            System.out.println("Task " + taskid + " failed ......");
            ts.markFailed(taskid);
        }

    }
}
