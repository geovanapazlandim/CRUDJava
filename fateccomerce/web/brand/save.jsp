<%-- 
    Document   : save
    Created on : 19/10/2022, 20:34:13
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Fatec Commerce - A loja do estudante</title>
    </head>
    <body>
        <h1>Formulário de marcas</h1>
        <form name="savebrand" action="${pageContext.request.contextPath}/SaveBrand" method="POST">
            <p><label>ID: </label><input type="number" id="idBrand" name="idbrand" readonly="readonly" value="${brand.idBrand}"/></p><br/>
            <p><label>Nome: </label><input type="text" id="nameBrand" name="namebrand" required="required" value="${brand.nameBrand}"/></p><br/>
            <p><label>Descrição: </label><textarea id="descriptionBrand" name="descriptionbrand" rows="5" cols="60" >${brand.descriptionBrand}</textarea></p><br/><br/>
            <input type="submit" id="salvar" name="salvar" value="Salvar"/>
            
        </form>
        <br/><br/>
        <h3>${response}</h3>
    </body>
</html>
