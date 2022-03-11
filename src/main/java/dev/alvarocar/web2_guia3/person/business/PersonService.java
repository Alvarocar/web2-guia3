package dev.alvarocar.web2_guia3.person.business;

import dev.alvarocar.web2_guia3.person.domain.Person;
import dev.alvarocar.web2_guia3.person.infra.PersonRepository;
import dev.alvarocar.web2_guia3.shared.infra.db.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PersonService {

  private Connection db;
  private Repository repo;

  public PersonService(Connection db) {
    this.db = db;
    this.repo = new PersonRepository(db);
  }

  public List<Person> getAll() throws SQLException {
    return this.repo.getAll();
  }

  public Optional<Person> getById(Integer id) throws SQLException {
    return this.repo.getById(id);
  }

  public Boolean add(Person newPerson) throws SQLException {
    return this.repo.add(newPerson);
  }

  public Boolean update(Person person) throws SQLException {
    return this.repo.edit(person);
  }

  public Boolean delete(Integer id) throws  SQLException {
    return this.repo.deleteById(id);
  }

}
