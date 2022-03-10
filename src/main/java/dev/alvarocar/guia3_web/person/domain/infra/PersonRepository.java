package dev.alvarocar.guia3_web.person.domain.infra;

import dev.alvarocar.guia3_web.person.domain.Person;
import dev.alvarocar.guia3_web.shared.infra.Repository;

import java.sql.*;
import java.util.ArrayList;
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
    PreparedStatement sentence = db.prepareStatement(query);
    ResultSet result = sentence.executeQuery();
    while (result.next()) {

    }
    db.close();
    return new ArrayList<>();
  }

  @Override
  public Optional<Person> getById(Integer id) throws SQLException {
    db.close();
    return Optional.empty();
  }

  @Override
  public Boolean add(Person entity) throws SQLException {
    db.close();
    return null;
  }

  @Override
  public Boolean edit(Person entity) throws SQLException {
    db.close();
    return null;
  }

  @Override
  public Boolean deleteById(Integer id) throws SQLException {
    db.close();
    return null;
  }
}
