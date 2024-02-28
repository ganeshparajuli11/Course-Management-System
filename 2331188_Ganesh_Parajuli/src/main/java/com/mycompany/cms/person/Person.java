
package com.mycompany.cms.person;


public class Person {
        private String fname;
        private String lname;
        private String email;
        private String password;
        private String phone;
        private String usertype;
        private int id;
        private String grade;
    
    public Person(){
        
    }
    
    public Person(String fname, String lname ,String email, String password, String usertype, int id){
        this.fname = fname;
        this.lname = lname;

        this.email = email;
        this.password = password;
     
        this.usertype = usertype;
        this.id = id;
    }
    
    public Person(String fname,String lname , String email, String password, String usertype){
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
//        this.grade= grade;
        this.usertype = usertype;
        
    }
    
    //student
    public Person(String fname, String lname ,String email, String password,String usertype,String grade ){
        
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.grade= grade;
        this.usertype = usertype;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setfName(String fname){
        this.fname = fname;
    }
    
    public String getfName(){
        return fname;
    }
    
    public void setlName(String lname){
        this.lname = lname;
    }
    
    public String getlName(){
        return lname;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPhone( String phone){
        this.phone = phone;
    }
    
    public String getPhone(){
        return phone;
    }
    public void setId(int id ){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    public void setUsertype(String usertype){
        this.usertype = usertype;
    }
    
    public String getUsertype(){
        return usertype;
    }
    
}
