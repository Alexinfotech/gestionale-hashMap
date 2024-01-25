<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Map" %>
<%@ page import="it.molinari.model.UtenteDTO" %>
<%@ page import="it.molinari.model.StudenteDTO" %>
<%@ page import="it.molinari.model.ProfessoreDTO" %>

<head>
    <title>Elenco Utenti</title>
</head>
<body>
    <h2>Elenco Utenti</h2>
    <ul>
        <%
        @SuppressWarnings("unchecked")
        Collection<UtenteDTO> utenti = (Collection<UtenteDTO>) request.getAttribute("utenti");
        if (utenti != null && !utenti.isEmpty()) {
            for (UtenteDTO utente : utenti) {
                if (utente instanceof StudenteDTO) {
                    StudenteDTO studente = (StudenteDTO) utente;
                    // Visualizza le informazioni specifiche dello studente
                    out.println("<li>Studente: " + studente.getId() + " -  "+ studente.getNome() + " " + studente.getCognome() + " - Corso di Studi: " + studente.getCorsoDiStudi() + "</li>");
                } else if (utente instanceof ProfessoreDTO) {
                    ProfessoreDTO professore = (ProfessoreDTO) utente;
                    // Visualizza le informazioni specifiche del professore
                    out.println("<li>Professore: " + professore.getId() + " -  "+ professore.getNome() + " " + professore.getCognome() + " - Materia: " + professore.getMateria() + "</li>");
                } else {
                    // Visualizza le informazioni generali dell'utente
                    out.println("<li>Utente: " + utente.getId() + " -  "+ utente.getNome() + " " + utente.getCognome() + "</li>");
                }
            }
        } else {
            out.println("<li>Nessun utente da visualizzare.</li>");
        }
        %>
    </ul>
    <div>
        <a href="index.html">Torna alla Home</a>
    </div>
</body>
</html>
