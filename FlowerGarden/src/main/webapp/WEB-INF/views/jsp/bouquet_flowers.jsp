<%--
  Created by IntelliJ IDEA.
  User: OleksiiF
  Date: 13.04.2018
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Bouquet Flowers:</title>
</head>
<body>
<div class="jumbotron">
<div class="container">
    <h1>${title}</h1>
    <p>
        <c:forEach items="${flowers}" var="flower">
            Flower name: ${flower.name} Flower id: ${flower.id}
            <br />
            Flower length: ${flower.lenght} Flower freshness: ${flower.freshness.freshness}
    <p>
        </c:forEach>
    </p>
</div>
</div>
</body>
</html>
