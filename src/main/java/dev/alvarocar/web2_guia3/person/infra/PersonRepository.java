package dev.alvarocar.web2_guia3.person.infra;

import dev.alvarocar.web2_guia3.person.domain.Person;
import dev.alvarocar.web2_guia3.shared.infra.db.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class PersonRepository implements Repository<Person, Integer> {

  private Connection db;

  public PersonRepository(Connection db) {
    this.db = db;
  }

  @Override
  public List<Person> getAll() throws SQLException {
    String query = "SELECT id, dni, name FROM person";
    PreparedStatement statement = db.prepareStatement(query);
    List<Person> people = new LinkedList<>();
    ResultSet result = statement.executeQuery();
    while (result.next()) {
      people.add(new Person(
        result.getInt(1),
        result.getInt(2),
        result.getString(3)
      ));
    }
    db.close();
    return people;
  }

  @Override
  public Optional<Person> getById(Integer id) throws SQLException {
    String query = "SELECT id, dni, name FROM person WHERE id = ?";
    PreparedStatement statement = db.prepareStatement(query);
    statement.setInt(1, id);
    ResultSet result = statement.executeQuery();
    Optional<Person> person = Optional.empty();
    while(result.next()) {
      person = Optional.of(new Person(
        result.getInt(1),
        result.getInt(2),
        result.getString(3)
      ));
    }
    db.close();
    return person;
  }

  @Override
  public Boolean add(Person entity) throws SQLException {
    String query = "INSERT INTO person (dni, name) VALUES (?, ?)";
    try {
      PreparedStatement statement = db.prepareStatement(query);
      statement.setInt(1, entity.getDni());
      statement.setString(2, entity.getName());
      statement.executeQuery();
    } catch(SQLException e) {
      e.printStackTrace();
      throw new SQLException("No se pudo insertar la nueva Persona");
    } finally {
      db.close();
    }
    return true;
  }

  @Override
  public Boolean edit(Person entity) throws SQLException {
    String query = "UPDATE person SET dni=?, name=? WHERE id=?";
    try {
      PreparedStatement statement = db.prepareStatement(query);
      statement.setInt(1, entity.getDni());
      statement.setString(2, entity.getName());
      statement.setInt(3, entity.getId());
      statement.executeQuery();
    } catch(SQLException e) {
      e.printStackTrace();
      throw new SQLException("No se pudo actualizar el registro de la persona");
    } finally {
      db.close();
    }
    return true;
  }

  @Override
  public Boolean deleteById(Integer id) throws SQLException {
    String query = "DELETE FROM person WHERE id=?";
    try {
      PreparedStatement statement = db.prepareStatement(query);
      statement.setInt(1, id);
      statement.executeQuery();
    } catch(SQLException e) {
      e.printStackTrace();
      throw new SQLException("No se pudo eliminar el registro de la persona");
    } finally {
      db.close();
    }
    return true;
  }
}
