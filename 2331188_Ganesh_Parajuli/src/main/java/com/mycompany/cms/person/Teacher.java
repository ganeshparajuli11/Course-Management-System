
package com.mycompany.cms.person;


public class Teacher {
    private int teacher_id;
    private int module_id;

    // Empty constructor
    public Teacher() {
    }
   
    // Constructor with all fields
    public Teacher(int teacher_id, int module_id) {
        this.teacher_id = teacher_id;
        this.module_id = module_id;
    }

    // Getter and setter methods for all fields...
    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getModule_id() {
        return module_id;
    }

    public void setModule_id(int module_id) {
        this.module_id = module_id;
    }
}
