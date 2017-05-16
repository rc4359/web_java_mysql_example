<%-- 
    Document   : show_table
    Created on : May 15, 2017, 4:58:17 PM
    Author     : richard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <sql:setDataSource
        var="lora_log"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost/php_ajax"
        user="root" password="000000"
        />
     
    <sql:query var="listUsers"   dataSource="${lora_log}">
        SELECT * FROM log1;
    </sql:query>
     

    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of users</h2></caption>
            <tr>
                <th>ID</th>
                <th>Addr</th>
                <th>sq</th>
                <th>Data</th>
            </tr>
            <c:forEach var="log1" items="${listUsers.rows}">
                <tr>
                    <td><c:out value="${log1.sn}" /></td>
                    <td><c:out value="${log1.addr}" /></td>
                    <td><c:out value="${log1.sequence}" /></td>
                    <td><c:out value="${log1.messages}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>        
    </body>
</html>
