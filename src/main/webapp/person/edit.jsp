<%--
  Created by IntelliJ IDEA.
  User: Alvaro
  Date: 12/03/2022
  Time: 08:22 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/person?action=edit">
    <input name="id" placeholder="ID" type="number" >
    <input name="dni" placeholder="DNI de la Persona" type="number" >
    <input name="name" placeholder="Nombre de la Persona" type="text">
    <button type="submit">Editar Usuario</button>
</form>
</body>
</html>
