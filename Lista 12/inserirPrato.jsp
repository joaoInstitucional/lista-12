<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Inserir Prato</title>
</head>
<body>
    <h1>Inserir Prato</h1>
    <form action="InserirPratoServlet" method="post">
        Nome: <input type="text" name="nome"><br>
        Tipo: <input type="text" name="tipo"><br>
        Ingredientes: <input type="text" name="ingredientes"><br>
        <input type="submit" value="Inserir Prato">
    </form>
</body>
</html>
