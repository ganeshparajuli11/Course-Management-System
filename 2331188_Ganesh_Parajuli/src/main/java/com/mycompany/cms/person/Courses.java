
package com.mycompany.cms.person;


public class Courses {
    private int course_id;
    private String course_name;
    private int is_canceled;
    
    // Empty constructor
    public Courses() {
    }

    // Constructor with course_id
    public Courses(int course_id, String course_name) {
        this.course_id = course_id;
        this.course_name = course_name;
    }

    // Constructor with course_name
    public Courses(String course_name) {
        this.course_name = course_name;
    }
    

    // Getter for course_id
    public int getCourse_id() {
        return course_id;
    }

    // Setter for course_id
    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    // Getter for course_name
    public String getCourse_name() {
        return course_name;
    }

    // Setter for course_name
    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    // Getter for is_canceled
    public int getIs_canceled() {
        return is_canceled;
    }

    // Setter for is_canceled
    public void setIs_canceled(int is_canceled) {
        this.is_canceled = is_canceled;
    }
}
