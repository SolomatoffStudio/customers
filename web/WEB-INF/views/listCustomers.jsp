<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta charset='utf-8'>
        <title>Customers</title>
    </head>
    <body>
        <p><b>List of customers</b></p>
        <table width="90%" border="1" cellpadding="4" cellspacing="0">
            <thead>
                    <tr>
                        <th>id</th>
                        <th>name</th>
                        <th>surname</th>
                        <th>e-mail</th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
            </thead>
            <c:set var="customers" value="${requestScope.customers}"/>
            <tbody>
                    <c:forEach var="customer" items="${customers}">
                        <tr>
                            <td><c:out value='${customer.id}'/></td>
                            <td><c:out value='${customer.name}'/></td>
                            <td><c:out value='${customer.surname}'/></td>
                            <td><c:out value='${customer.email}'/></td>
                            <td align="center">
                                <form  action='${pageContext.servletContext.contextPath}/rudcustomer' method='GET'>
                                    <input type='hidden' name='action' value='Update Customer'>
                                    <input type='hidden' name='id' value='${customer.id}'>
                                    <input type='submit' value='Edit'>
                                </form>
                            </td>
                            <td align="center">
                                <form  action='${pageContext.servletContext.contextPath}/rudcustomer' method='GET'>
                                    <input type='hidden' name='action' value='Delete Customer'>
                                    <input type='hidden' name='id' value='${customer.id}'>
                                    <input type='submit' value='Delete'>
                                </form>
                            </td>
                            <td align="center">
                                <form  action='${pageContext.servletContext.contextPath}/rudcustomer' method='GET'>
                                    <input type='hidden' name='action' value='Find By Id Customer'>
                                    <input type='hidden' name='id' value='${customer.id}'>
                                    <input type='submit' value='View'>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
            </tbody>
        </table>
        <p>
            <form action='${pageContext.servletContext.contextPath}/createcustomer' method='GET'>
                <input type='hidden' name='action' value='Create Customer'>
                <input type='submit' value='New'>
            </form>
        <p>
        <ul>
            <li><a href="${pageContext.servletContext.contextPath}/index.xhtml">Back to Main Page</a></li>
        </ul>
    </body>
</html>