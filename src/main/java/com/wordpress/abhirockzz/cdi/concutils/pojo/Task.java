package com.wordpress.abhirockzz.cdi.concutils.pojo;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Task {
    private String taskid;
    private TaskState state;
    private Date start;
    private Date end;

    public Task() {
    }
    
    
    public Task(String taskid, TaskState state, Date start, Date end) {
        this.taskid = taskid;
        this.state = state;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Task{" + "taskid=" + taskid + ", state=" + state + ", start=" + start + ", end=" + end + '}';
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }
    
    
    
}
