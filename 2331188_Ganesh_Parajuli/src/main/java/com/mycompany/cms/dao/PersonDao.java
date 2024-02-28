package com.mycompany.cms.dao;

import com.mycompany.cms.person.Person;
import java.sql.SQLException;
import java.util.List;


public interface PersonDao {

    Person findOne(String email, String password) throws SQLException, ClassNotFoundException;
    List<Person> findAllStudent() throws SQLException, ClassNotFoundException;
    List<Person> findAllTeacher() throws SQLException, ClassNotFoundException;
    int updateTeacher(Person person, int id) throws SQLException, ClassNotFoundException;
    Person findOne(int id) throws SQLException, ClassNotFoundException;
    int remove(int id) throws SQLException, ClassNotFoundException;
    int save(Person person) throws SQLException, ClassNotFoundException;
    int saveGrade(Person person) throws SQLException, ClassNotFoundException;
    int updateStudent(Person person, int id) throws SQLException, ClassNotFoundException;
    List<Person> search(String query) throws SQLException, ClassNotFoundException;
}

