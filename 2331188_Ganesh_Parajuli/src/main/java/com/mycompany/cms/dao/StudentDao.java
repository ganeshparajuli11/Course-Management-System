package com.mycompany.cms.dao;
import com.mycompany.cms.person.Student;
import java.sql.SQLException;
import java.util.List;


public interface StudentDao {
   
    int save(Student student) throws SQLException, ClassNotFoundException;

    int update(Student student, int id) throws SQLException, ClassNotFoundException;
    int updateMarks(Student student, int id, int module_id) throws SQLException, ClassNotFoundException;

    int remove(int id) throws SQLException, ClassNotFoundException;

    Student findOne(int id) throws SQLException, ClassNotFoundException;

    List<Student> findAll() throws SQLException, ClassNotFoundException;

    List<Student> search(String query) throws SQLException, ClassNotFoundException;
    List<Student> findAll(int id) throws SQLException, ClassNotFoundException;
    List<Student> findAll(int id, int module_id) throws SQLException, ClassNotFoundException;
}

