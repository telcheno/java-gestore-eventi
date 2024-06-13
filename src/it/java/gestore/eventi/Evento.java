package it.java.gestore.eventi;


import java.time.LocalDate;

//Creo classe abstratta evento per fare implementare 
//metodi e atributi alle classe che la stendono
public abstract class Evento {
	
	//Creo atributi classe evento
    private String titolo;
    private LocalDate data;
    private int numeroPostiTotali;
    protected int numeroPostiPrenotati;

    //Creo costruttore con gli atributi da ereditare nelle classe che lo stendono
    public Evento (String titolo, LocalDate data, int numeroPostiTotali) {
        this.titolo = titolo;
        this.data = data;
        this.numeroPostiTotali = numeroPostiTotali;
        this.numeroPostiPrenotati = 0;
    }

    //metodi getter e setter
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getNumeroPostiTotali() {
        return numeroPostiTotali;
    }

    public int getNumeroPostiPrenotati() {
        return numeroPostiPrenotati;
    }

    public void setNumeroPostiPrenotati(int numeroPostiPrenotati) {
        this.numeroPostiPrenotati = numeroPostiPrenotati;
    }

    //Controllo se la data non sia gia pasata
    public boolean isDataValida() {
        return !data.isBefore(LocalDate.now());
    }

    //Metodo per prenotare
    public void prenota(int numeroPrenotazioni) {
    	
    	//Controllo se la data non è gia pasata
    	if (!isDataValida()) {
            System.out.println("La data non è valida, l'evento è già passato.");
            return;
        }
    	
    	//Controllo se le condizioni tra la data e la disponibilita del posti sia valida per la prenotazione
        if (numeroPrenotazioni > 0 && numeroPrenotazioni <= (numeroPostiTotali - numeroPostiPrenotati)) {
            setNumeroPostiPrenotati(numeroPostiPrenotati + numeroPrenotazioni);
            System.out.println("Prenotazione effettuata. \n Posti prenotati: " 
            + getNumeroPostiPrenotati() + "\n Posti disponibili: " + (numeroPostiTotali - numeroPostiPrenotati));
        
        //Altrimenti aviso che la prenotazione non è valida
        } else {
            System.out.println("Prenotazione non valida: o non ci sono posti disponibili o la data non è valida.");
        }
    }

    public void disdici(int numeroDisdette) {
    	
    	//Controllo se la data sia valida
        if (!isDataValida()) {
            System.out.println("La data non è valida, l'evento è già passato.");
            return;
        }

        //Controlo tra le condizioni per potere efetuare la disdetta
        if (numeroDisdette > 0 && numeroDisdette <= numeroPostiPrenotati) {
            setNumeroPostiPrenotati(numeroPostiPrenotati - numeroDisdette);
            System.out.println("Disdetta effettuata. \n Posti prenotati: \n" + getNumeroPostiPrenotati() + ", Posti disponibili: " + (numeroPostiTotali - numeroPostiPrenotati));
           
        //Altrimenti aviso che la prenotazione non è valida
        } else {
            System.out.println("Disdetta non valida: \n o non ci sono abbastanza prenotazioni \n o la data non è valida.");
        }
    }

    //Metodo to String da ereditare alla classe che stendonola super lcasse
    @Override
    public String toString() {
        return "DATI DELL'EVENTO: \n" +
                "Titolo: " + titolo + "\n" +
                "Data: " + data + "\n" +
                "Posti totali: " + numeroPostiTotali + "\n" +
                "Posti prenotati: " + numeroPostiPrenotati + "\n";
    }
}
