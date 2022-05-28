<%--
  Created by IntelliJ IDEA.
  User: daonhuanh
  Date: 5/28/22
  Time: 10:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
List Class
<c:forEach items="${ds}" var="cl">
    <h1>${cl.name}</h1>
</c:forEach>
</body>
</html>
