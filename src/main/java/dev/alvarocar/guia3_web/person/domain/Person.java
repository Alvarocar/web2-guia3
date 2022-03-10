package dev.alvarocar.guia3_web.person.domain;

public class Person {
  private Integer id;
  private Integer dni;
  private String name;

  public Person(Integer id, Integer dni, String name) {
    this.id = id;
    this.dni = dni;
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public Integer getDni() {
    return dni;
  }

  public String getName() {
    return name;
  }
}
