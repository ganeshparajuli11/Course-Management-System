
package com.mycompany.cms.person;


public class Modules {
    private int module_id;
    private String module_name;
    private int level;
    private int is_Deleted;
    private int is_Optional;
    private int course_id;

    // Empty constructor
    public Modules() {
    }

    // Constructor with module_id
    public Modules(int module_id) {
        this.module_id = module_id;
    }

    // Constructor with module_name
    public Modules(String module_name) {
        this.module_name = module_name;
    }

    // Constructor with all fields
    public Modules( String module_name, int level, int is_Deleted, int is_Optional, int course_id) {
        
        this.module_name = module_name;
        this.level = level;
        this.is_Deleted = is_Deleted;
        this.is_Optional = is_Optional;
        this.course_id = course_id;
    }

    // Getter and setter methods for all fields...
    public int getModule_id() {
        return module_id;
    }

    public void setModule_id(int module_id) {
        this.module_id = module_id;
    }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getIs_Deleted() {
        return is_Deleted;
    }

    public void setIs_Deleted(int is_Deleted) {
        this.is_Deleted = is_Deleted;
    }

    public int getIs_Optional() {
        return is_Optional;
    }

    public void setIs_Optional(int is_Optional) {
        this.is_Optional = is_Optional;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
}

