package it.java.gestore.eventi;


import java.time.LocalDate;
import java.time.LocalTime;

//Creo classe concerto che stende la classe astratta evento per ereditare i metodi e gli atributi
public class Concerto extends Evento {
	
	//Creo le variabili specifiche della classe
    private LocalTime ora;
    private double prezzo;
    private int prenotazioni;
    private int disdette;

    //Creo il costruttore della classe con gli atributi ereditari della clase astartta evento
    public Concerto(String titolo, LocalDate data, int numeroPostiTotali, LocalTime ora, double prezzo) {
        super(titolo, data, numeroPostiTotali);
        this.ora = ora;
        this.prezzo = prezzo;
       
    }

    //Metodi getter e setter

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}


	public LocalTime getOra() {
        return ora;
    }

    public double getPrezzo() {
        return prezzo;
    }

    //metodi prenota e disdice ereditati dalla super classe
    @Override
    public void prenota(int numeroPrenotazioni) {
        if (numeroPrenotazioni > 0 && numeroPrenotazioni <= (getNumeroPostiTotali() - getNumeroPostiPrenotati())) {
            this.prenotazioni += numeroPrenotazioni;
            setNumeroPostiPrenotati(getNumeroPostiPrenotati() + numeroPrenotazioni);
            System.out.println("Prenotazione effettuata.\n TI ASPETIAMO AL CONCERTO!! \n Posti prenotati: " + getNumeroPostiPrenotati() + ", Posti disponibili: " + (getNumeroPostiTotali() - getNumeroPostiPrenotati()));
        } else {
            System.out.println("Prenotazione non valida: non ci sono posti disponibili.");
        }
    }

    @Override
    public void disdici(int numeroDisdette) {
        if (numeroDisdette > 0 && numeroDisdette <= prenotazioni) {
            this.disdette += numeroDisdette;
            setNumeroPostiPrenotati(getNumeroPostiPrenotati() - numeroDisdette);
            System.out.println("Disdette effettuate. \n PECATO TI ASPETIAMO NEL PROSSIMO CONCERTO!! \n Posti prenotati: " + getNumeroPostiPrenotati() + ", Posti disponibili: " + (getNumeroPostiTotali() - getNumeroPostiPrenotati()));
        } else {
            System.out.println("Disdetta non valida: non ci sono abbastanza prenotazioni.");
        }
    }

    //Override del metodo toString che stentede il metodo della super classe
    @Override
    public String toString() {
        return super.toString() +
                "Ora: " + this.ora + "\n" +
                "Prezzo: " + this.prezzo + " € \n" +
                "Prenotazioni: " + this.prenotazioni + "\n" +
                "Disdette: " + this.disdette + "\n";
    }
}
