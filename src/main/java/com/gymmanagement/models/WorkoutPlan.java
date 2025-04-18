
package com.gymmanagement.models;

import java.time.LocalDate;

public class WorkoutPlan {
    private int id;
    private int memberId;
    private int trainerId;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String goal;
    private String difficulty;
    private String status;
    private String exercises; // JSON formatted list of exercises

    public WorkoutPlan() {
    }

    public WorkoutPlan(int id, int memberId, int trainerId, String name, String description, LocalDate startDate,
                      LocalDate endDate, String goal, String difficulty, String status, String exercises) {
        this.id = id;
        this.memberId = memberId;
        this.trainerId = trainerId;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.goal = goal;
        this.difficulty = difficulty;
        this.status = status;
        this.exercises = exercises;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExercises() {
        return exercises;
    }

    public void setExercises(String exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString() {
        return "WorkoutPlan{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", trainerId=" + trainerId +
                ", name='" + name + '\'' +
                ", goal='" + goal + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
