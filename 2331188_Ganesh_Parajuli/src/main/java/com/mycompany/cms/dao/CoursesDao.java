package com.mycompany.cms.dao;

import com.mycompany.cms.person.Courses;

import java.sql.SQLException;
import java.util.List;

public interface CoursesDao {

    int save(Courses course) throws SQLException, ClassNotFoundException;

    int update(Courses course, int id) throws SQLException, ClassNotFoundException;

    int remove(int id) throws SQLException, ClassNotFoundException;

    Courses findOne(int id) throws SQLException, ClassNotFoundException;

    List<Courses> findAll() throws SQLException, ClassNotFoundException;

    List<Courses> search(String query) throws SQLException, ClassNotFoundException;
}

