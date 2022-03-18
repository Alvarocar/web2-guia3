package dev.alvarocar.web2_guia3.person.domain;

public class Person {
  private Integer id;
  private Integer dni;
  private String name;

  public Person(Integer id, Integer dni, String name) {
    this.id = id;
    this.dni = dni;
    this.name = name;
  }

  public Person(Integer dni, String name) {
    this.dni = dni;
    this.name = name;
  }

  public Integer getId() {
    return this.id;
  }

  public Integer getDni() {
    return this.dni;
  }

  public String getName() {
    return this.name;
  }
}
