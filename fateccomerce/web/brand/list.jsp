<%-- 
    Document   : save
    Created on : 19/10/2022, 20:34:13
    Author     : Aluno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Fatec Commerce - A loja do estudante</title>
    </head>
    <body>
        <h1>Lista marcas</h1>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Descrição</th>
                    <th colspan="2">Editar</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="brand" items="${brands}">
                    <tr>
                        <td>${brand.idBrand}</td>
                        <td>${brand.nameBrand}</td>
                        <td>${brand.descriptionBrand}</td>
                        <td><a href="${pageContext.request.contextPath}/DeleteBrand?idBrand=${brand.idBrand}">Excluir</a></td>
                        <td><a href="${pageContext.request.contextPath}/FindByIdBrand?idBrand=${brand.idBrand}">Alterar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br/><br/>
        <h3>${response}</h3>
    </body>
</html>
