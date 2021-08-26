package com.gujun.test;

import java.time.LocalDateTime;

/**
 * @ClassName: Task
 * @Author GuJun
 * @Description:
 * @Date 2021年08月24日 16:45
 */
public class Task {

    private String name;

    private LocalDateTime localDateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
