<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Map" %>
<%@ page import="it.molinari.model.UtenteDTO" %>
<%@ page import="it.molinari.model.StudenteDTO" %>
<%@ page import="it.molinari.model.ProfessoreDTO" %>

<html>
<head>
    <title>Ricerca</title>
</head>
<body>
    <h2>Ricerca Utente Tramite ID da Modificare  </h2>

<form id="searchForm" action="Utenti" method="get">
    <label for="id">ID:</label>
    <input type="text" id="id" name="id"><br><br>
    <input type="submit" value="Modifica">
</form>

</body>
</html>
