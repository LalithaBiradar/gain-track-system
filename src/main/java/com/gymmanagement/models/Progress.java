
package com.gymmanagement.models;

import java.time.LocalDate;

public class Progress {
    private int id;
    private int memberId;
    private LocalDate recordDate;
    private double weight;
    private double bodyFatPercentage;
    private double musclePercentage;
    private double chestSize;
    private double waistSize;
    private double armSize;
    private double legSize;
    private String notes;

    public Progress() {
    }

    public Progress(int id, int memberId, LocalDate recordDate, double weight, double bodyFatPercentage,
                   double musclePercentage, double chestSize, double waistSize, double armSize,
                   double legSize, String notes) {
        this.id = id;
        this.memberId = memberId;
        this.recordDate = recordDate;
        this.weight = weight;
        this.bodyFatPercentage = bodyFatPercentage;
        this.musclePercentage = musclePercentage;
        this.chestSize = chestSize;
        this.waistSize = waistSize;
        this.armSize = armSize;
        this.legSize = legSize;
        this.notes = notes;
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

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBodyFatPercentage() {
        return bodyFatPercentage;
    }

    public void setBodyFatPercentage(double bodyFatPercentage) {
        this.bodyFatPercentage = bodyFatPercentage;
    }

    public double getMusclePercentage() {
        return musclePercentage;
    }

    public void setMusclePercentage(double musclePercentage) {
        this.musclePercentage = musclePercentage;
    }

    public double getChestSize() {
        return chestSize;
    }

    public void setChestSize(double chestSize) {
        this.chestSize = chestSize;
    }

    public double getWaistSize() {
        return waistSize;
    }

    public void setWaistSize(double waistSize) {
        this.waistSize = waistSize;
    }

    public double getArmSize() {
        return armSize;
    }

    public void setArmSize(double armSize) {
        this.armSize = armSize;
    }

    public double getLegSize() {
        return legSize;
    }

    public void setLegSize(double legSize) {
        this.legSize = legSize;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Progress{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", recordDate=" + recordDate +
                ", weight=" + weight +
                ", bodyFatPercentage=" + bodyFatPercentage +
                '}';
    }
}
