
package com.mycompany.cms.dao.imp;

import static com.mycompany.cms.connectionfactory.ConnectionFactory.getConnection;
import com.mycompany.cms.person.Person;
import com.mycompany.cms.dao.PersonDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PersonDaoImp implements PersonDao{
    @Override
    public Person findOne(String email, String password) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = getConnection()
                .prepareStatement("select *from person where email = ? && password = ?");
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();
        Person person = new Person();
        if (resultSet.next()) {
            person.setEmail(resultSet.getString("email"));
            person.setPassword(resultSet.getString("password"));
            person.setfName(resultSet.getString("first_name"));
            person.setlName(resultSet.getString("last_name"));
            person.setId(resultSet.getInt("id"));
            person.setUsertype(resultSet.getString("type"));


        }else{
            return null;
        }
        return person;
    }
    
    @Override
    public int updateStudent(Person person, int id) throws SQLException, ClassNotFoundException {
        String updateSQL = "update person set first_name = ?, last_name = ?,"
                + " email = ?, password = ?, type = student where id = ?";
        PreparedStatement prepareStatement = getConnection().prepareStatement(updateSQL);
        prepareStatement.setString(1, person.getfName());
        prepareStatement.setString(2, person.getlName());
        prepareStatement.setString(3, person.getEmail());
        prepareStatement.setString(4, person.getPassword());
        prepareStatement.setInt(5, id);
        return prepareStatement.executeUpdate();
    }

@Override
    public int updateTeacher(Person person, int id) throws SQLException, ClassNotFoundException {
        String updateSQL = "update person set first_name = ?, last_name = ?,"
                + " email = ?, password = ?, type = teacher where id = ?";
        PreparedStatement prepareStatement = getConnection().prepareStatement(updateSQL);
        prepareStatement.setString(1, person.getfName());
        prepareStatement.setString(2, person.getlName());
        prepareStatement.setString(3, person.getEmail());
        prepareStatement.setString(4, person.getPassword());
        prepareStatement.setInt(5, id);
        return prepareStatement.executeUpdate();
    }  
    
    @Override
    public List<Person> search(String query) throws SQLException, ClassNotFoundException {
        List<Person> persons = new ArrayList<>();
        PreparedStatement preparedStatement = getConnection().prepareStatement(
                "select *from person where first_name like concat ('%' ? '%')"
                + "or last_name like concat ('%' ? '%') "
                
                        + "or email like concat ('%' ? '%') "
                        + "or type like concat ('%' ? '%') "
                + "or cast(id as char) like ('%' ? '%') ");
               
        preparedStatement.setString(1, query);
        preparedStatement.setString(2, query);
        preparedStatement.setString(3, query);
        preparedStatement.setString(4, query);
        preparedStatement.setString(5, query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Person person = new Person();
            person.setEmail(resultSet.getString("email"));
            person.setPassword(resultSet.getString("password"));
            person.setfName(resultSet.getString("first_name"));
            person.setlName(resultSet.getString("last_name"));
            person.setId(resultSet.getInt("id"));
            person.setUsertype(resultSet.getString("type"));
            persons.add(person);
        }
        return persons;
    }
    
    @Override
    public Person findOne(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = getConnection()
                .prepareStatement("select *from person where id = ?");
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        Person person = new Person();
        if (resultSet.next()) {
            person.setEmail(resultSet.getString("email"));
            person.setPassword(resultSet.getString("password"));
            person.setfName(resultSet.getString("first_name"));
            person.setlName(resultSet.getString("last_name"));
            person.setId(resultSet.getInt("id"));
            person.setUsertype(resultSet.getString("type"));


        }else{
            return null;
        }
        return person;
    }
    
    @Override
    public int remove(int id) throws SQLException, ClassNotFoundException {
        String deleteSQL = "delete from person where id = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(deleteSQL);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }
    
     @Override
    public int save(Person person) throws SQLException, ClassNotFoundException {
        
        String insertSQL = "insert into person (id, first_name, last_name, email, password, type) values(?,?,?,?,?,?)";
        PreparedStatement prepareStatement = getConnection().prepareStatement(insertSQL);
        prepareStatement.setInt(1, person.getId());
        prepareStatement.setString(2, person.getfName());
        prepareStatement.setString(3, person.getlName());
        prepareStatement.setString(4, person.getEmail());
        prepareStatement.setString(5, person.getPassword());
        prepareStatement.setString(6, person.getUsertype());
        return prepareStatement.executeUpdate();
    }
    
    public int saveGrade(Person person) throws SQLException, ClassNotFoundException {
        
        String insertSQL = "insert into person (grade) values(?)";
        PreparedStatement prepareStatement = getConnection().prepareStatement(insertSQL);
        prepareStatement.setString(1, person.getGrade());
        
        return prepareStatement.executeUpdate();
    }
    
     @Override
    public List<Person> findAllStudent() throws SQLException, ClassNotFoundException {
        List<Person> persons = new ArrayList<>();
        PreparedStatement preparedStatement = getConnection()
                .prepareStatement("select * from person where type = 'student'");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Person person = new Person();
            person.setEmail(resultSet.getString("email"));
            person.setPassword(resultSet.getString("password"));
            person.setfName(resultSet.getString("first_name"));
            person.setlName(resultSet.getString("last_name"));

            person.setId(resultSet.getInt("id"));
            person.setUsertype(resultSet.getString("type"));
            persons.add(person);
        }
        return persons;
    }
    
     @Override
    public List<Person> findAllTeacher() throws SQLException, ClassNotFoundException {
        List<Person> persons = new ArrayList<>();
        PreparedStatement preparedStatement = getConnection()
                .prepareStatement("select * from person where type = 'teacher'");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Person person = new Person();
            person.setEmail(resultSet.getString("email"));
            person.setPassword(resultSet.getString("password"));
            person.setfName(resultSet.getString("first_name"));
            person.setlName(resultSet.getString("last_name"));

            person.setId(resultSet.getInt("id"));
            person.setUsertype(resultSet.getString("type"));
            persons.add(person);
        }
        return persons;
    }
}
