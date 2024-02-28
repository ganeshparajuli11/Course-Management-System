package com.mycompany.cms.dao.imp;

import static com.mycompany.cms.connectionfactory.ConnectionFactory.getConnection;
import com.mycompany.cms.dao.TeacherDao;
import com.mycompany.cms.person.Teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class TeacherDaoImp implements TeacherDao {

    @Override
    public int save(Teacher teacher) throws SQLException, ClassNotFoundException {
        String insertSQL = "INSERT INTO teacher (teacher_id, module_id) VALUES (?, ?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(insertSQL);
        preparedStatement.setInt(1, teacher.getTeacher_id());
        preparedStatement.setInt(2, teacher.getModule_id());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int update(Teacher teacher, int id) throws SQLException, ClassNotFoundException {
        String updateSQL = "UPDATE teacher SET teacher_id = ?, module_id = ? WHERE teacher_id = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(updateSQL);
        preparedStatement.setInt(1, teacher.getTeacher_id());
        preparedStatement.setInt(2, teacher.getModule_id());
        preparedStatement.setInt(3, id);
        return preparedStatement.executeUpdate();
    }

    @Override
    public int remove(int id) throws SQLException, ClassNotFoundException {
        String deleteSQL = "DELETE FROM teacher WHERE teacher_id = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(deleteSQL);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }

    @Override
    public Teacher findOne(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT * FROM teacher WHERE teacher_id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Teacher teacher = new Teacher();
        while (resultSet.next()) {
            teacher.setTeacher_id(resultSet.getInt("teacher_id"));
            teacher.setModule_id(resultSet.getInt("module_id"));
        }
        return teacher;
    }

    @Override
    public List<Teacher> findAll() throws SQLException, ClassNotFoundException {
        List<Teacher> teachers = new ArrayList<>();
        PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT * FROM teacher");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Teacher teacher = new Teacher();
            teacher.setTeacher_id(resultSet.getInt("teacher_id"));
            teacher.setModule_id(resultSet.getInt("module_id"));
            teachers.add(teacher);
        }
        return teachers;
    }

    @Override
    public List<Teacher> search(String query) throws SQLException, ClassNotFoundException {
        List<Teacher> teachers = new ArrayList<>();
        PreparedStatement preparedStatement = getConnection().prepareStatement(
                "SELECT * FROM teacher WHERE teacher_id LIKE CONCAT('%', ?, '%') "
                + "OR module_id LIKE CONCAT('%', ?, '%')");
        preparedStatement.setString(1, query);
        preparedStatement.setString(2, query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Teacher teacher = new Teacher();
            teacher.setTeacher_id(resultSet.getInt("teacher_id"));
            teacher.setModule_id(resultSet.getInt("module_id"));
            teachers.add(teacher);
        }
        return teachers;
    }
}

