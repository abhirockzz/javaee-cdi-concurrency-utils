package com.wordpress.abhirockzz.cdi.concutils.pojo;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AllTasks {
    List<Task> tasks;

    public AllTasks() {
        
    }

    public AllTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    
}
