# Web Application Login con Spring

Benvenuti nel repository di un'applicazione web di login sviluppata utilizzando **Spring Framework**. Questo progetto integra un sistema di autenticazione per gli utenti, un'interfaccia di gestione dei dati e un modulo per effettuare operazioni matematiche. La parte front-end è stata sviluppata utilizzando **HTML** e **Bootstrap**.

## Funzionalità Principali

1. **Sistema di Login**

    - Gli utenti possono registrarsi e accedere utilizzando le loro credenziali.

2. **Gestione degli Utenti**

    - Utilizzo dell'entity `Utente` per rappresentare i dati degli utenti:
  
      - ID: Identificativo univoco dell'utente
  
      - Name: Nome dell'utente
  
      - Password: Password per l'autenticazione
  
      - Address: Indirizzo associato all'utente

3. **Reportistica**

    - Implementazione di un'entity `Report` per la gestione e visualizzazione di report associati agli utenti.

4. **Calcolatrice**

    - Una classe `Calcolatrice` consente agli utenti di effettuare operazioni matematiche una volta loggati nel sistema.

5. **Interfaccia utente**

    - Front-end costruito con HTML e Bootstrap, offrendo un design responsive e intuitivo.

## Struttura del Progetto

### Backend

- **Tecnologia**: Spring Framework

- **Microservizi**:

  - Entity `Utente`: Gestisce i dati relativi agli utenti, interfacciandosi con il database.

  - Entity `Report`: Modello per la gestione dei report.

  - Classe `Calcolatrice`: Implementa le operazioni matematiche per gli utenti autenticati.

- **Database**: Strutturato per memorizzare i dati degli utenti e dei report.

### Frontend

- **HTML**: Per la struttura delle pagine.

- **Bootstrap**: Per uno stile moderno e un layout responsive.

## Requisiti

### Software Necessari

- **Java 21+**

- **Maven**

- **MySQL** (o altro database relazionale)

- **Spring Boot 3.x**

- **Browser Web** (Google Chrome, Firefox, ecc.)

## Struttura dei File

- **src/main/java**: Contiene il codice sorgente.

  - `com.example.calcolatrice.model`: Contiene le classi `Utente`, `Report` e `Calcolatrice`.

  - `com.example.calcolatrice.service`: Contiene la logica del servizio.

  - `com.example.calcolatrice.controller`: Contiene i controller per gestire le richieste.

- **src/main/resources**: Contiene le risorse del progetto.

  - `application.properties`: File di configurazione.

  - `/templates`: Contiene i file front-end.

## Configurazione del Progetto

1. **Clona il Repository**

    ```git clone https://github.com/tuo-username/nome-repository.git```

2. **Configura il Database**

    - Crea un database MySQL chiamato `calcolatrice_db`
    - Aggiorna il file `application.properties` con le tue credenziali:

      ```
      spring.datasource.url=jdbc:mysql://localhost:3306/calcolatrice_db
      spring.datasource.username=tuo-username
      spring.datasource.password=tuo-password

3. **Esegui il Progetto**

4. **Accedi all'Applicazione**

    - Apri il browser e vai su: `http://localhost:8080`

