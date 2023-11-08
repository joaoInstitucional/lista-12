<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Pratos</title>
</head>
<body>
    <h1>Lista de Pratos</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Tipo</th>
            <th>Ingredientes</th>
        </tr>
        <c:forEach items="${pratos}" var="prato">
            <tr>
                <td>${prato.id}</td>
                <td>${prato.nome}</td>
                <td>${prato.tipo}</td>
                <td>${prato.ingredientes}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
