<%@ page import="java.util.Map" %>
<%@ page import="it.molinari.model.ProfessoreDTO" %>

<!DOCTYPE html>
<html>
<head>
    <title>Inserimento Utente</title>
</head>
<body>


    <form id="userForm" action="Utenti" method="POST">
        <h2>Inserisci Nuovo Utente</h2>
        
        <input type="hidden" name="tipoUtente" value="professore">

       

        <label for="id">Id:</label> 
        <input type="text" id="id" name="id"><br><br> 
        <label for="nome">Nome:</label> 
        <input type="text" id="nome" name="nome"><br><br>
        <label for="cognome">Cognome:</label>
        <input type="text" id="cognome" name="cognome"><br><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email"><br><br>
        <label for="via">Via:</label> 
        <input type="text" id="via" name="via"><br><br>
        <label for="citta">Città:</label> 
        <input type="text" id="citta" name="citta"><br><br>
        <label for="codice_postale">Codice Postale:</label> 
        <input type="text" id="codice_postale" name="codice_postale"><br><br> 
        <label for="nazione">Nazione:</label>
        <input type="text" id="nazione" name="nazione"><br><br>
            <label for="materia">Materia:</label>
            <input type="text" id="materia" name="materia"><br><br>
          

 

        <input type="submit" value="Invia">
    </form>


</body>
</html>
