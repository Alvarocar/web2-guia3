package dev.alvarocar.web2_guia3.person.infra;

import dev.alvarocar.web2_guia3.person.business.PersonService;
import dev.alvarocar.web2_guia3.person.domain.Person;
import dev.alvarocar.web2_guia3.shared.infra.db.MysqlConnector;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "person", value = "/person")
public class PersonController extends HttpServlet {

  private Connection con;

  public void init() {
    try {
      this.con = MysqlConnector.getConnector().getConnection();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("text/html");
    String actionType = request.getParameter("action");
    if (actionType == null) {
      actionType = "list";
    }
    String finalRoute = "";
    switch (actionType) {
      case "list":
        finalRoute = "person/list.jsp";
        break;
      case "edit":
        finalRoute = "person/edit.jsp";
        break;
      case "new":
        finalRoute = "person/new.jsp";
        break;
      default:
        finalRoute = "notfound.jsp";
        break;
    }
    RequestDispatcher dispacher = request.getRequestDispatcher(finalRoute);
    dispacher.forward(request, response);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    String type = request.getParameter("action");

    try {
      switch (type) {
        case "new":
          newPerson(request, response);
          break;
        case "edit":
          editPerson(request, response);
          break;
        case "delete":
          deletePerson(request, response);
          break;
        default:
          RequestDispatcher dispacher = request.getRequestDispatcher("error.jsp");
          dispacher.forward(request, response);
          break;
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      RequestDispatcher dispacher = request.getRequestDispatcher("error.jsp");
      dispacher.forward(request, response);
    }

  }

  private void newPerson(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
    String name = request.getParameter("name");
    Integer dni = Integer.parseInt(request.getParameter("dni"));
    PersonService service = new PersonService(this.con);
    if (service.add(new Person(dni, name))) {
      RequestDispatcher dispacher = request.getRequestDispatcher("person/list.jsp");
      dispacher.forward(request, response);
     }
  }

  private void editPerson(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
    Integer id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    Integer dni = Integer.parseInt(request.getParameter("dni"));
    PersonService service = new PersonService(this.con);
    if (service.update(new Person(id, dni, name))) {
      RequestDispatcher dispacher = request.getRequestDispatcher("person/list.jsp");
      dispacher.forward(request, response);
    }
  }

  private void deletePerson(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
    Integer id = Integer.parseInt(request.getParameter("id"));
    PersonService service = new PersonService(this.con);
    if (service.delete(id)) {
      RequestDispatcher dispacher = request.getRequestDispatcher("person/list.jsp");
      dispacher.forward(request, response);
    }
  }

  public void destroy() {
  }
}