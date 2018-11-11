<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset='utf-8'>
        <c:set var="act" value="${param.action}"/>
        <title><c:out value="${act}"/></title>
    </head>
    <body>
        <p><b><c:out value="${act}"/></b></p>
        <form id="rudCustomerForm" action='${pageContext.servletContext.contextPath}/rudcustomer' method='post'>
            <input type='hidden' name='action' value='${act}'><Br>
            <b>customer id:</b> <input type='number' name='id' value='${customer.id}' readonly><Br>
            <b>customer name:</b> <input type='text' name='name' value='${customer.name}'><Br>
            <b>customer surname:</b> <input required type='text' name='surname' value='${customer.surname}'><Br>
            <b>customer e-mail:</b> <input type='text' name='email' value='${customer.email}'><Br>
            <p><input type='submit' value='Accept'></p>
        </form>
    </body>
</html>

