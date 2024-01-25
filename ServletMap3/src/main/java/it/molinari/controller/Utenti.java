
package it.molinari.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import it.molinari.model.ProfessoreDTO;
import it.molinari.model.StudenteDTO;
import it.molinari.model.UtenteDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Utenti")

public class Utenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> utentiMap = new HashMap<>();

	// ... altri metodi (doGet, costruttore, ecc.)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String id = request.getParameter("id");
	    String action = request.getParameter("action");


		if ("utenti".equals(id)) {
			request.setAttribute("utenti", utentiMap.values());
			request.getRequestDispatcher("/elencoUtenti.jsp").forward(request, response);
		} else if ("UTENTE".equals(id)) {
			request.getRequestDispatcher("/formUtente.jsp").forward(request, response);
		} else if ("STUDENTE".equals(id)) {
			request.getRequestDispatcher("/formStudente.jsp").forward(request, response);
		} else if ("PROFESSORE".equals(id)) {
			request.getRequestDispatcher("/formProfessore.jsp").forward(request, response);
		
		
		} else if ("ID".equals(id)) {
			request.getRequestDispatcher("/ricercaUtenteModifica.jsp").forward(request, response);
		} else if ("IDID".equals(id)) {
	        request.getRequestDispatcher("/ricercaUtenteElimina.jsp").forward(request, response);
	    } else if ("ELIMINA".equals(action) && id != null && !id.trim().isEmpty()) {

	        Object utenteTrovato = utentiMap.get(id);
	        if (utenteTrovato != null) {
	            request.setAttribute("utente", utenteTrovato);
	            request.getRequestDispatcher("/Elimina.jsp").forward(request, response);
	        } else {
	            request.setAttribute("errorMessage", "Nessun utente trovato con l'ID specificato: " + id);
	            request.getRequestDispatcher("/erroreRicerca.jsp").forward(request, response);
	        }
	    } else if (id != null && !id.trim().isEmpty()) {
	    	Object utenteTrovato = utentiMap.get(id);
	        if (utenteTrovato != null) {
	            request.setAttribute("utente", utenteTrovato);
	            request.getRequestDispatcher("/modifica.jsp").forward(request, response);
	        } else {
	            request.setAttribute("errorMessage", "Nessun utente trovato con il codice fiscale specificato: " + id);
	            request.getRequestDispatcher("/erroreRicerca.jsp").forward(request, response);
	        }
	    } else {
	        request.setAttribute("errorMessage", "Codice fiscale non fornito o non valido.");
	        request.getRequestDispatcher("/erroreRicerca.jsp").forward(request, response);
	    }
	}
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String method = request.getParameter("_method");
	        if ("DELETE".equalsIgnoreCase(method)) {
	            doDelete(request, response);
	        } else if ("PUT".equalsIgnoreCase(method)) {
	            doPut(request, response);
	        } else {
	            String id = request.getParameter("id");
	            String tipoUtente = request.getParameter("tipoUtente"); // Parametro per distinguere il tipo di utente

	            switch (tipoUtente) {
	                case "studente":
	                    StudenteDTO studente = creaStudenteDTO(request);
	                    aggiungiUtenteSeNonEsiste(studente, id, request, response);
	                    break;
	                case "professore":
	                    ProfessoreDTO professore = creaProfessoreDTO(request);
	                    aggiungiUtenteSeNonEsiste(professore, id, request, response);
	                    break;
	                default:
	                    UtenteDTO utente = creaUtenteDTO(request);
	                    aggiungiUtenteSeNonEsiste(utente, id, request, response);
	                    break;
	            }
	        }
	    }

	private StudenteDTO creaStudenteDTO(HttpServletRequest request) {
		// Logica per creare e impostare i campi di StudenteDTO
		String id = request.getParameter("id");
		String ruolo = request.getParameter("ruolo");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String via = request.getParameter("via");
		String città = request.getParameter("citta");
		String codicePostale = request.getParameter("codice_postale");
		String nazione = request.getParameter("nazione");
		String corsoDiStudi = request.getParameter("corso_di_studi");
		String classe = request.getParameter("classe");
		// Imposta i vari campi di StudenteDTO con i parametri della richiesta
		// ...
		StudenteDTO studente = new StudenteDTO();

		studente.setId(id);
		studente.setRuolo(ruolo);
		studente.setNome(nome);
		studente.setCognome(cognome);
		studente.setEmail(email);
		studente.setVia(via);
		studente.setCitta(città);
		studente.setCodicePostale(codicePostale);
		studente.setNazione(nazione);
		studente.setCorsoDiStudi(corsoDiStudi);
		studente.setClasse(classe);

		return studente;
	}

	private ProfessoreDTO creaProfessoreDTO(HttpServletRequest request) {
		// Logica per creare e impostare i campi di ProfessoreDTO
		String id = request.getParameter("id");
		String ruolo = request.getParameter("ruolo");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String via = request.getParameter("via");
		String città = request.getParameter("citta");
		String codicePostale = request.getParameter("codice_postale");
		String nazione = request.getParameter("nazione");
		String materia = request.getParameter("materia");

		ProfessoreDTO professore = new ProfessoreDTO();
		// Imposta i vari campi di ProfessoreDTO con i parametri della richiesta
		// ...

		professore.setId(id);
		professore.setRuolo(ruolo);
		professore.setNome(nome);
		professore.setCognome(cognome);
		professore.setEmail(email);
		professore.setVia(via);
		professore.setCitta(città);
		professore.setCodicePostale(codicePostale);
		professore.setNazione(nazione);
		professore.setMateria(materia);

		return professore;
	}

	private UtenteDTO creaUtenteDTO(HttpServletRequest request) {
		// Logica per creare e impostare i campi di UtenteDTO
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String via = request.getParameter("via");
		String città = request.getParameter("citta");
		String codicePostale = request.getParameter("codice_postale");
		String nazione = request.getParameter("nazione");

		UtenteDTO utente = new UtenteDTO();
		utente.setId(id);
		utente.setNome(nome);
		utente.setCognome(cognome);
		utente.setEmail(email);
		utente.setVia(via);
		utente.setCitta(città);
		utente.setCodicePostale(codicePostale);
		utente.setNazione(nazione);

		// ...
		return utente;
	}

	private void aggiungiUtenteSeNonEsiste(Object utente, String id, HttpServletRequest request,
	        HttpServletResponse response) throws IOException, ServletException {

	    if (!utentiMap.containsKey(id)) {
	        if (utente instanceof StudenteDTO) {
	            // Gestisci l'aggiunta di uno StudenteDTO
	        } else if (utente instanceof ProfessoreDTO) {
	            // Gestisci l'aggiunta di un ProfessoreDTO
	        } else if (utente instanceof UtenteDTO) {
	            // Gestisci l'aggiunta di un UtenteDTO generico
	        }

	        utentiMap.put(id, utente);
	        response.sendRedirect("successInseriti.jsp");
	    } else {
	        request.setAttribute("errorMessage", "Un utente con questo codice fiscale esiste già.");
	        request.getRequestDispatcher("/formUtente.jsp").forward(request, response);
	    }
	}
	  @Override
	    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String id = request.getParameter("id");

	        if (id != null && !id.trim().isEmpty()) {
	            if (utentiMap.containsKey(id)) {
	                utentiMap.remove(id);
	                response.setStatus(HttpServletResponse.SC_OK);
	    			response.sendRedirect("successEliminati.jsp");
	            } else {
	                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	                request.setAttribute("errorMessage", "Nessun utente trovato con l'ID specificato: " + id);
	    	        request.getRequestDispatcher("/erroreRicerca.jsp").forward(request, response);
	    	  
	            }
	        } else {
	            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	        //    response.getWriter().write("ID non fornito o non valido.");
	            request.getAttribute("ID non fornito o non valido.");
    	        request.getRequestDispatcher("/erroreRicerca.jsp").forward(request, response);
    	  
	            
	        }
	    }
	  @Override
	  protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      // Ottieni l'ID dell'utente dalla richiesta
	      String id = req.getParameter("id");

	      // Verifica se l'utente esiste nella mappa degli utenti
	      if (utentiMap.containsKey(id)) {
	          // Ottieni l'utente esistente dalla mappa
	          Object utenteEsistente = utentiMap.get(id);

	          // Inizializza una variabile per l'utente aggiornato
	          Object utenteAggiornato = null;

	          // Verifica il tipo dell'utente esistente
	          if (utenteEsistente instanceof StudenteDTO) {
	              // Se è uno studente, crea un nuovo oggetto StudenteDTO con i dati aggiornati
	              utenteAggiornato = creaStudenteDTO(req);
	          } else if (utenteEsistente instanceof ProfessoreDTO) {
	              // Se è un professore, crea un nuovo oggetto ProfessoreDTO con i dati aggiornati
	              utenteAggiornato = creaProfessoreDTO(req);
	          } 

	          if (utenteAggiornato != null) {
	              // Aggiorna l'utente nella mappa con l'utente aggiornato
	              utentiMap.put(id, utenteAggiornato);

	              // Reindirizza l'utente a una pagina di successo
	              resp.sendRedirect("successModificati.jsp");
	          } else {
	              // Se la creazione dell'utente aggiornato ha fallito, imposta un messaggio di errore
	              req.setAttribute("errorMessage", "Errore durante l'aggiornamento dell'utente.");
	          }
	      } else {
	          // Se l'utente non è stato trovato nella mappa, imposta un messaggio di errore
	          req.setAttribute("errorMessage", "Nessun utente trovato con il codice fiscale specificato.");
	      }
	  }
}