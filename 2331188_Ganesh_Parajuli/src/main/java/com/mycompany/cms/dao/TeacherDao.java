package com.mycompany.cms.dao;

import com.mycompany.cms.person.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherDao {

    int save(Teacher teacher) throws SQLException, ClassNotFoundException;

    int update(Teacher teacher, int id) throws SQLException, ClassNotFoundException;

    int remove(int id) throws SQLException, ClassNotFoundException;

    Teacher findOne(int id) throws SQLException, ClassNotFoundException;

    List<Teacher> findAll() throws SQLException, ClassNotFoundException;

    List<Teacher> search(String query) throws SQLException, ClassNotFoundException;
}