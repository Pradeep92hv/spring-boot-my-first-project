package com.pradeep.rest.webservices.restfull_web_services.todo;
import  java.util.*;

public class Todo{
    private long id;
    private String username;
    private String description;
    private Date targetDate;
    private Boolean isDone;

    protected  Todo(){

    }
    public Todo(Boolean isDone, Date targetDate, String description, String username, long id) {

        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public Boolean getDone() {
        return isDone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id == todo.id && Objects.equals(targetDate, todo.targetDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public void setDone(Boolean done) {
        isDone = done;
    }
}
