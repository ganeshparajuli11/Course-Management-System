package com.mycompany.cms.dao.imp;


import static com.mycompany.cms.connectionfactory.ConnectionFactory.getConnection;

import com.mycompany.cms.dao.CoursesDao;
import com.mycompany.cms.person.Courses;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CoursesDaoImp implements CoursesDao {

    @Override
    public int save(Courses course) throws SQLException, ClassNotFoundException {
        String insertSQL = "INSERT INTO course (course_name, is_canceled) VALUES (?, 0)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(insertSQL);
        preparedStatement.setString(1, course.getCourse_name());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int update(Courses course, int id) throws SQLException, ClassNotFoundException {
        String updateSQL = "UPDATE course SET course_name = ? WHERE course_id = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(updateSQL);
        preparedStatement.setString(1, course.getCourse_name());
        
        preparedStatement.setInt(2, id);
        return preparedStatement.executeUpdate();
    }

    @Override
    public int remove(int id) throws SQLException, ClassNotFoundException {
        String deleteSQL = "UPDATE course SET is_canceled = 1 WHERE course_id = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(deleteSQL);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }

    @Override
    public Courses findOne(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT * FROM course WHERE course_id = ? and is_canceled=0");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Courses course = new Courses();
        while (resultSet.next()) {
            course.setCourse_id(resultSet.getInt("course_id"));
            course.setCourse_name(resultSet.getString("course_name"));
            course.setIs_canceled(resultSet.getInt("is_canceled"));
        }
        return course;
    }

    @Override
    public List<Courses> findAll() throws SQLException, ClassNotFoundException {
        List<Courses> courses = new ArrayList<>();
        PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT * FROM course where is_canceled = 0");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Courses course = new Courses();
            course.setCourse_id(resultSet.getInt("course_id"));
            course.setCourse_name(resultSet.getString("course_name"));
            course.setIs_canceled(resultSet.getInt("is_canceled"));
            courses.add(course);
        }
        return courses;
    }

    @Override
    public List<Courses> search(String query) throws SQLException, ClassNotFoundException {
        List<Courses> courses = new ArrayList<>();
        PreparedStatement preparedStatement = getConnection().prepareStatement(
                "SELECT * FROM course WHERE course_id LIKE CONCAT('%', ?, '%') "
                + "OR course_name LIKE CONCAT('%', ?, '%') "
                + "OR is_canceled LIKE CONCAT('%', ?, '%')");
        preparedStatement.setString(1, query);
        preparedStatement.setString(2, query);
        preparedStatement.setString(3, query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Courses course = new Courses();
            course.setCourse_id(resultSet.getInt("course_id"));
            course.setCourse_name(resultSet.getString("course_name"));
            course.setIs_canceled(resultSet.getInt("is_canceled"));
            courses.add(course);
        }
        return courses;
    }
}