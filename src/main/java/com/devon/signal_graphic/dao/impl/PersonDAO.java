package main.java.com.devon.signal_graphic.dao.impl;

import main.java.com.devon.signal_graphic.bean.Person;
import main.java.com.devon.signal_graphic.dao.AbstractGenericDAO;
import main.java.com.devon.signal_graphic.util.CountProperty;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class PersonDAO extends AbstractGenericDAO<Person, Integer> {
    @Override
    protected String getTableName() {
        return "person";
    }
    @Override
    protected String getInsertColumns() {
    return "name, money";
    }
    @Override
    protected String getInsertPlaceholders() {
        int count = CountProperty.getPropertyCount(Person.class);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < count - 1; i++) {
            if (i == count - 2){
                stringBuilder.append("?");
            } else {
                stringBuilder.append("?, ");
            }
        }
        return stringBuilder.toString();
    }
    @Override
    protected Person mapRowToObject(ResultSet rs) throws SQLException {
        Person person = new Person();
        person.setId(rs.getInt("id"));
        person.setName(rs.getString("name"));
        person.setMoney(rs.getInt("money"));
        return person;
    }
    @Override
    protected void setInsertStatementParameters(PreparedStatement stmt, Person entity) throws SQLException {
        stmt.setString(1, entity.getName());
        stmt.setInt(2, entity.getMoney());
    }
    @Override
    protected void setUpdateStatementParameters(PreparedStatement stmt, Map<String, Object> updates) throws SQLException {
        int index = 1;
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            stmt.setObject(index++, entry.getValue());
        }
    }
}
