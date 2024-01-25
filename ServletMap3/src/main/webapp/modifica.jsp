<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="it.molinari.model.UtenteDTO"%>
<%@ page import="it.molinari.model.StudenteDTO"%>
<%@ page import="it.molinari.model.ProfessoreDTO"%>

<!DOCTYPE html>
<html>
<head>
    <title>Modifica Utente</title>
</head>
<body>

    <% if (request.getAttribute("errorMessage") != null) { %>
        <p style="color: red;"><%=request.getAttribute("errorMessage")%></p>
    <% } %>

    <% UtenteDTO utente = (UtenteDTO) request.getAttribute("utente");
       if (utente != null) { %>
    
        <form action="Utenti" method="post">
            <h2>Modifica Utente</h2>
            <input type="hidden" name="_method" value="PUT">
            <input type="hidden" name="id" value="<%=utente.getId()%>">
			<label for="nome">Nome:</label> <input type="text" id="nome" name="nome"
			value="<%=utente.getNome()%>"><br>
		<br> <label for="cognome">Cognome:</label> <input type="text"
			id="cognome" name="cognome" value="<%=utente.getCognome()%>"><br>
		<br> <label for="email">Email:</label> <input type="email"
			id="email" name="email" value="<%=utente.getEmail()%>"><br>
		<br> <label for="via">Via:</label> <input type="text" id="via"
			name="via" value="<%=utente.getVia()%>"><br>
		<br> <label for="citta">Città:</label> <input type="text"
			id="citta" name="citta" value="<%=utente.getCitta()%>"><br>
		<br> <label for="codice_postale">Codice Postale:</label> <input
			type="text" id="codice_postale" name="codice_postale"
			value="<%=utente.getCodicePostale()%>"><br>
		<br> <label for="nazione">Nazione:</label> <input type="text"
			id="nazione" name="nazione" value="<%=utente.getNazione()%>"><br>
		<br>

		<!-- Campi specifici per StudenteDTO e ProfessoreDTO -->
		<%
		if (utente instanceof StudenteDTO) {
			StudenteDTO studente = (StudenteDTO) utente;
		%>
		<div>
			<label for="corso_di_studi">Corso di Studi:</label> <input
				type="text" id="corso_di_studi" name="corso_di_studi"
				value="<%=studente.getCorsoDiStudi()%>"><br>
			<br> <label for="classe">Classe:</label> <input type="text"
				id="classe" name="classe" value="<%=studente.getClasse()%>"><br>
			<br>
		</div>
		<%
		} else if (utente instanceof ProfessoreDTO) {
		ProfessoreDTO professore = (ProfessoreDTO) utente;
		%>
		<div>
			<label for="materia">Materia:</label> <input type="text" id="materia"
				name="materia" value="<%=professore.getMateria()%>"><br>
			<br>
		</div>
		<%
		}
		%>
            <input type="submit" value="Modifica">
        </form>

    <% } else { %>
        <p>Utente non trovato.</p>
    <% } %>

    <div>
        <a href="index.html">Torna alla Home</a>
    </div>

</body>
</html>
