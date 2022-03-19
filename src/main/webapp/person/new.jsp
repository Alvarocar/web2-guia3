<%--
  Created by IntelliJ IDEA.
  User: Alvaro
  Date: 12/03/2022
  Time: 08:21 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/person?action=new">
        <input name="dni" placeholder="DNI de la Persona" type="number" >
        <input name="name" placeholder="Nombre de la Persona" type="text">
        <button type="submit">Crear nuevo Usuario</button>
    </form>
</body>
</html>
