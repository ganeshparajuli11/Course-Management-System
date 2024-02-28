package com.mycompany.cms.dao;

import com.mycompany.cms.person.Modules;

import java.sql.SQLException;
import java.util.List;

public interface ModuleDao {

    int save(Modules module) throws SQLException, ClassNotFoundException;

    int update(Modules module, int id) throws SQLException, ClassNotFoundException;

    int remove(int id) throws SQLException, ClassNotFoundException;

    Modules findOne(int id) throws SQLException, ClassNotFoundException;

    List<Modules> findAll() throws SQLException, ClassNotFoundException;

    List<Modules> search(String query) throws SQLException, ClassNotFoundException;
}