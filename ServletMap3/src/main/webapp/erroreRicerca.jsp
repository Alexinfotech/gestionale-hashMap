<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Map" %>
<%@ page import="it.molinari.model.UtenteDTO" %>
<%@ page import="it.molinari.model.StudenteDTO" %>
<%@ page import="it.molinari.model.ProfessoreDTO" %>

<head>
    <title>Ricerca Utente - Errore</title>
    <style>
        .error-message {
            color: red;
            font-size: 16px;
            margin: 20px;
            padding: 10px;
            border: 1px solid red;
            display: inline-block;
            background-color: #ffd2d2;
        }
    </style>
</head>
<body>

    <h1>Errore nella Ricerca Utente</h1>
    <% 
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null && !errorMessage.trim().isEmpty()) {
            out.println("<div class=\"error-message\">" + errorMessage + "</div>");
        }
    %>

    <div>
        <a href="index.html">Torna alla Home</a>
    </div>

</body>
</html>
