package com.mycompany.cms.dao.imp;

import static com.mycompany.cms.connectionfactory.ConnectionFactory.getConnection;
import com.mycompany.cms.dao.ModuleDao;
import com.mycompany.cms.person.Modules;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModuleDaoImp implements ModuleDao {

    @Override
    public int save(Modules module) throws SQLException, ClassNotFoundException {
        String insertSQL = "INSERT INTO module ( module_name, level, is_Deleted, is_Optional, course_id) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(insertSQL);
        
        preparedStatement.setString(1, module.getModule_name());
        preparedStatement.setInt(2, module.getLevel());
        preparedStatement.setInt(3, module.getIs_Deleted());
        preparedStatement.setInt(4, module.getIs_Optional());
        preparedStatement.setInt(5, module.getCourse_id());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int update(Modules module, int id) throws SQLException, ClassNotFoundException {
        String updateSQL = "UPDATE module SET module_id = ?, module_name = ?, level = ?, is_Deleted = ?, is_Optional = ?, course_id = ? WHERE module_id = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(updateSQL);
        preparedStatement.setInt(1, module.getModule_id());
        preparedStatement.setString(2, module.getModule_name());
        preparedStatement.setInt(3, module.getLevel());
        preparedStatement.setInt(4, module.getIs_Deleted());
        preparedStatement.setInt(5, module.getIs_Optional());
        preparedStatement.setInt(6, module.getCourse_id());
        preparedStatement.setInt(7, id);
        return preparedStatement.executeUpdate();
    }

    @Override
    public int remove(int id) throws SQLException, ClassNotFoundException {
        String deleteSQL = "UPDATE module SET is_Deleted = 1 WHERE module_id = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(deleteSQL);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }

    @Override
    public Modules findOne(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT * FROM module WHERE module_id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Modules module = new Modules();
        while (resultSet.next()) {
            module.setModule_id(resultSet.getInt("module_id"));
            module.setModule_name(resultSet.getString("module_name"));
            module.setLevel(resultSet.getInt("level"));
            module.setIs_Deleted(resultSet.getInt("is_Deleted"));
            module.setIs_Optional(resultSet.getInt("is_Optional"));
            module.setCourse_id(resultSet.getInt("course_id"));
        }
        return module;
    }

    @Override
    public List<Modules> findAll() throws SQLException, ClassNotFoundException {
        List<Modules> modules = new ArrayList<>();
        PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT * FROM module where is_Deleted = 0");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Modules module = new Modules();
            module.setModule_id(resultSet.getInt("module_id"));
            module.setModule_name(resultSet.getString("module_name"));
            module.setLevel(resultSet.getInt("level"));
            module.setIs_Deleted(resultSet.getInt("is_Deleted"));
            module.setIs_Optional(resultSet.getInt("is_Optional"));
            module.setCourse_id(resultSet.getInt("course_id"));
            modules.add(module);
        }
        return modules;
    }

    @Override
    public List<Modules> search(String query) throws SQLException, ClassNotFoundException {
        List<Modules> modules = new ArrayList<>();
        PreparedStatement preparedStatement = getConnection().prepareStatement(
                "SELECT * FROM module WHERE (module_id LIKE CONCAT('%', ?, '%') "
                + "OR module_name LIKE CONCAT('%', ?, '%') "
                + "OR level LIKE CONCAT('%', CAST(? AS CHAR), '%') " // Convert level to string
                + "OR course_id LIKE CONCAT('%', CAST(? AS CHAR), '%')) and is_Deleted = 0");
        preparedStatement.setString(1, query);
        preparedStatement.setString(2, query);
        preparedStatement.setString(3, query);
        preparedStatement.setString(4, query);
      
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Modules module = new Modules();
            module.setModule_id(resultSet.getInt("module_id"));
            module.setModule_name(resultSet.getString("module_name"));
            module.setLevel(resultSet.getInt("level"));
            module.setIs_Deleted(resultSet.getInt("is_Deleted"));
            module.setIs_Optional(resultSet.getInt("is_Optional"));
            module.setCourse_id(resultSet.getInt("course_id"));
            modules.add(module);
        }
        return modules;
    }
}

