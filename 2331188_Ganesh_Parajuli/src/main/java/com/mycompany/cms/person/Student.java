
package com.mycompany.cms.person;


public class Student {
    private int id;
    private int module_id;
    private double marks;
    private String grade;

    // Empty constructor
    public Student() {
    }

    // Constructor with all fields
    public Student(int id, int module_id, double marks, String grade) {
        this.id = id;
        this.module_id = module_id;
        this.marks = marks;
        this.grade = grade;
    }

    // Getter and setter methods for all fields...
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModule_id() {
        return module_id;
    }

    public void setModule_id(int module_id) {
        this.module_id = module_id;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

