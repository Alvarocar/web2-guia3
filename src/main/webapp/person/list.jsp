<%@ page import="dev.alvarocar.web2_guia3.person.business.PersonService" %>
<%@ page import="dev.alvarocar.web2_guia3.shared.infra.db.MysqlConnector" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="dev.alvarocar.web2_guia3.person.domain.Person" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personas</title>
    <style>
        h1 {
            font-size: 2rem;
        }
        ul {
            list-style: none;
            margin: 0;
            padding: 0;
        }
        ul li {
            font-size: 1.5em;
            padding: 1rem .5rem;
            display: flex;
            justify-content: start;
            gap: .5rem;
        }

        ul li button {
            background-color: crimson;
            border: none;
            padding: .5rem;
            border-radius: 50%;
        }
        ul li button:hover {
            opacity: .7;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h1>Personas</h1>
    <ul>
        <%
            PersonService service = new PersonService(
              MysqlConnector.getConnector().getConnection());
            List<Person> people = service.getAll();
            for (Person per: people) {

        %>
        <li><span><%=per.getId() %> <%=per.getDni() %> <%= per.getName() %></span>
            <form method="post" action="${pageContext.request.contextPath}<%="/person?action=delete&id="+per.getId()+""%>"><button>X</button></form>
        </li>
        <% } %>
    </ul>
</body>
</html>
