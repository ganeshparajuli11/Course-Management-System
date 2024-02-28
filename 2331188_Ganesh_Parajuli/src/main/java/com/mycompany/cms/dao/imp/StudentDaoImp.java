package com.mycompany.cms.dao.imp;

import static com.mycompany.cms.connectionfactory.ConnectionFactory.getConnection;
import com.mycompany.cms.dao.StudentDao;
import com.mycompany.cms.person.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDaoImp implements StudentDao{
    
    @Override
    public int save(Student student) throws SQLException, ClassNotFoundException {
        String insertSQL = "INSERT INTO student (id, module_id, marks, grade) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(insertSQL);
        preparedStatement.setInt(1, student.getId());
        preparedStatement.setInt(2, student.getModule_id());
        preparedStatement.setDouble(3, student.getMarks());
        preparedStatement.setString(4, student.getGrade());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int update(Student student, int id) throws SQLException, ClassNotFoundException {
        String updateSQL = "UPDATE student SET module_id = ?, marks = ?, grade = ? WHERE id = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(updateSQL);
     
        preparedStatement.setInt(1, student.getModule_id());
        preparedStatement.setDouble(2, student.getMarks());
        preparedStatement.setString(3, student.getGrade());
        preparedStatement.setInt(4, id);
        return preparedStatement.executeUpdate();
    }
    @Override
    public int updateMarks(Student student, int id,int module_id) throws SQLException, ClassNotFoundException {
        String updateSQL = "UPDATE student SET marks = ? WHERE id = ? and module_id = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(updateSQL);
     
      
        preparedStatement.setDouble(1, student.getMarks());

        preparedStatement.setInt(2, id);
                preparedStatement.setInt(3, module_id);

        return preparedStatement.executeUpdate();
    }

    @Override
    public int remove(int id) throws SQLException, ClassNotFoundException {
        String deleteSQL = "DELETE FROM student WHERE id = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(deleteSQL);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }

    @Override
    public Student findOne(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT * FROM student WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Student student = new Student();
        while (resultSet.next()) {
            student.setId(resultSet.getInt("id"));
            student.setModule_id(resultSet.getInt("module_id"));
            student.setMarks(resultSet.getDouble("marks"));
            student.setGrade(resultSet.getString("grade"));
        }
        return student;
    }

    
   
    
    @Override
    public List<Student> findAll() throws SQLException, ClassNotFoundException {
        List<Student> students = new ArrayList<>();
        PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT * FROM student");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setModule_id(resultSet.getInt("module_id"));
            student.setMarks(resultSet.getDouble("marks"));
            student.setGrade(resultSet.getString("grade"));
            students.add(student);
        }
        return students;
    }
    
    @Override
    public List<Student> findAll(int id) throws SQLException, ClassNotFoundException {
        List<Student> students = new ArrayList<>();
        PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT * FROM student where id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setModule_id(resultSet.getInt("module_id"));
            student.setMarks(resultSet.getDouble("marks"));
            student.setGrade(resultSet.getString("grade"));
            students.add(student);
        }
        return students;
    }
    
    @Override
    public List<Student> findAll(int id, int module_id) throws SQLException, ClassNotFoundException {
        List<Student> students = new ArrayList<>();
        PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT * FROM student where id = ? and module_id = ?");
        preparedStatement.setInt(1, id);
                preparedStatement.setInt(2, module_id);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setModule_id(resultSet.getInt("module_id"));
            student.setMarks(resultSet.getDouble("marks"));
            student.setGrade(resultSet.getString("grade"));
            students.add(student);
        }
        return students;
    }

    @Override
    public List<Student> search(String query) throws SQLException, ClassNotFoundException {
        List<Student> students = new ArrayList<>();
        PreparedStatement preparedStatement = getConnection().prepareStatement(
                "SELECT * FROM student WHERE id LIKE CONCAT('%', ?, '%') "
                + "OR module_id LIKE CONCAT('%', ?, '%') "
                + "OR marks LIKE CONCAT('%', ?, '%') "
                + "OR grade LIKE CONCAT('%', ?, '%')");
        preparedStatement.setString(1, query);
        preparedStatement.setString(2, query);
        preparedStatement.setString(3, query);
        preparedStatement.setString(4, query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setModule_id(resultSet.getInt("module_id"));
            student.setMarks(resultSet.getDouble("marks"));
            student.setGrade(resultSet.getString("grade"));
            students.add(student);
        }
        return students;
    }
}