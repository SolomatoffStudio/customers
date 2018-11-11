<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Create Customer</title>
        <meta charset='utf-8'>
    </head>
    <body>
        <p><b>Create Customer</b></p>
        <form id="createForm" action='${pageContext.servletContext.contextPath}/rudcustomer' method='post'>
            <input type='hidden' name='action' value='Create Customer'><Br>
            <b>customer id:</b> <input required type='hidden' name='id' value=${requestScope.customer.id}><Br>
            <b>customer name:</b> <input type='text' name='name' value="Enter a name in this field"><Br>
            <b>customer surname:</b> <input required type='text' name='surname' value="Enter a surname in this field"><Br>
            <b>customer e-mail:</b> <input type='text' name='email' value="Enter a e-mail in this field"><Br>
            <p><input type='submit' value='Accept'></p>
        </form>
    </body>
</html>

