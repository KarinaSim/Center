<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8" http-equiv="refresh" content="1" />
    <title>Animal List</title>
</head>
<body>
<div>
    <table border="2">
        <caption>Animal list</caption>
        <tr>
            <th>type</th>
            <th>name</th>
            <th>cost</th>
            <th>character</th>
            <th>breed</th>
            <th>degreeOfPollution</th>
        </tr>
        <c:forEach  items="${animals}" var ="animal">
            <tr>
                <td>${animal.getClass().getSimpleName()}</td>
                <td>${animal.name}</td>
                <td>${animal.cost}</td>
                <td>${animal.character}</td>
                <td>${animal.breed}</td>
                <td>${animal.degreeOfPollution}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>
