package it.java.gestore.eventi;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainGestore {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Richiesta dei dettagli dell'evento
        System.out.print("Scegli il titolo dell'evento: \n - Concerto, \n - Mostra, \n - Convention. \n");
        String scelta = input.nextLine();

        // Formato la risposta in maiuscolo
        String eventoScelto = scelta.toUpperCase();

        // Data evento formatata per la richiesta
        System.out.print("Inserisci la data dell'evento (dd/MM/yyyy): \n");
        
        //Formato la data del utente per il controlo delle prenotazioni e disdette
        String dataString = input.nextLine();
        DateTimeFormatter dataFormatata = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(dataString, dataFormatata);

        // Ora evento
        System.out.print("Inserisci l'ora dell'evento (HH:mm): \n");
        
        //Formato l'ora del utente
        String oraString = input.nextLine();
        DateTimeFormatter oraFormatata = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime ora = LocalTime.parse(oraString, oraFormatata);

        // Posti totali dell'evento
        System.out.print("Inserisci il numero totale di posti dell'evento: \n");
        int numeroPostiTotali = input.nextInt();
        
        input.nextLine();  

        // Prezzo del ingreso al evento evento
        System.out.print("Inserisci il prezzo dell'evento: \n");
        double prezzo = input.nextDouble();
        input.nextLine();  

        // Creazione oggetto Concerto con i dati forniti dall'utente 
        Concerto concerto = new Concerto(eventoScelto, data, numeroPostiTotali, ora, prezzo);

        // Controllo se la data dell'evento è valida (la data non deve essere prima della data attuale)
        if (!concerto.isDataValida()) {
            System.out.println("La data non è valida, l'evento è già passato.");
            return;
        }

        // Gestione delle prenotazioni
        //Chiedo al utente quanti posti vuole prenotare
        System.out.print("Quante prenotazioni vuoi fare? \n");
        int numeroPrenotazioni = input.nextInt();
        
        //Invoco il metodo prenota con il atributo valorizato dal input chiesto dal utente
        concerto.prenota(numeroPrenotazioni);

        // Stampa dei posti prenotati e disponibili
        System.out.println("Posti prenotati: " + concerto.getNumeroPostiPrenotati());
        System.out.println("Posti disponibili: " + (concerto.getNumeroPostiTotali() - concerto.getNumeroPostiPrenotati()));

        // Gestione delle disdette
      //Chiedo al utente quanti posti vuole disdire
        System.out.print("Quanti posti vuoi disdire? \n");
        int numeroDisdette = input.nextInt();
        
        //Invoco il metodo disdice con il atributo valorizato dal input chiesto dal utente
        concerto.disdici(numeroDisdette);

        // Visualizzazione dello stato finale delle prenotazioni
        System.out.println("Posti prenotati: " + concerto.getNumeroPostiPrenotati());
        System.out.println("Posti disponibili: " + (concerto.getNumeroPostiTotali() - concerto.getNumeroPostiPrenotati()));
        System.out.println("\n");

        // Visualizzazione dei dettagli dell'evento
        System.out.println(concerto);
    }
}
