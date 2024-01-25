# Gestione Utenti - Sistema Web Java

Questo progetto implementa un'applicazione web in Java per la gestione degli utenti, con supporto per diversi tipi di utenti come studenti, professori e utenti generici. Il sistema permette di inserire, modificare, visualizzare e cancellare le informazioni degli utenti.

## Caratteristiche

- **Gestione Diversificata**: Supporto per la gestione di diversi tipi di utenti (Studenti, Professori, Utenti generici).
- **Interfaccia Utente Dinamica**: Interfaccia web dinamica che si adatta in base al tipo di utente selezionato.
- **CRUD Completo**: Funzionalità complete di Creazione, Lettura, Aggiornamento ed Eliminazione (CRUD) per i dati degli utenti.
- **Architettura Scalabile**: Progettato per essere facilmente estendibile ad altri tipi di utenti e funzionalità.

## Tecnologie Utilizzate

- **Backend**: Java, Servlet, Jakarta EE
- **Frontend**: HTML, CSS, JavaScript
- **Database**: (specificare il sistema di gestione del database, se applicabile)
- **Server**: (specificare il server web o l'ambiente di esecuzione, es. Tomcat, Jetty)

## Struttura del Progetto

- `src`: Contiene il codice sorgente dell'applicazione.
    - `controller`: Servlet per la gestione delle richieste HTTP.
    - `model`: Classi DTO (Data Transfer Object) per Studente, Professore e Utente generico.
- `web`: Contiene le pagine HTML, CSS e JavaScript.
- `README.md`: Documentazione del progetto.

## Come Iniziare

1. **Configurazione dell'Ambiente**: Assicurarsi di avere installato Java e il server web (es. Tomcat).
2. **Clonare il Repository**: `git clone [URL del repository]`.
3. **Importare il Progetto**: Aprire il progetto in un IDE (es. Eclipse) come progetto Java EE.
4. **Configurazione del Database**: (istruzioni specifiche, se necessario).
5. **Esecuzione dell'Applicazione**: Avviare il server e navigare all'URL dell'applicazione.

## Contribuire

Siamo aperti a contributi! Se desideri contribuire al progetto, ti preghiamo di leggere le `CONTRIBUTING.md` per le linee guida sullo sviluppo.
