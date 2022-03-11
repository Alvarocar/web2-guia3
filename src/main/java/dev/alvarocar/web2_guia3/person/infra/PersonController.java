package dev.alvarocar.web2_guia3.person.infra;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "person", value = "/person")
public class PersonController extends HttpServlet {
  private final String index = "person/index.jsp";

  public void init() { }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("text/html");

    RequestDispatcher dispacher = request.getRequestDispatcher(index);
    dispacher.forward(request, response);
  }

  public void destroy() {
  }
}