package org.java.gestore_eventi;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Evento {
    private String titolo;
    private Date data;
    private int numeroPostiTotale;
    private int numeroPostiPrenotati;

 
    public Evento(String titolo, Date data, int numeroPostiTotale) throws Exception {
        if (data.before(new Date()) || numeroPostiTotale <= 0) {
            throw new Exception("Data già passata o numero di posti totali non valido.");
        }

        this.titolo = titolo;
        this.data = data;
        this.numeroPostiTotale = numeroPostiTotale;
        this.numeroPostiPrenotati = 0;
    }

 
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Date getData() {
        return data;
    }
    
    public Date setData(Date data) {
    	return this.data=data;
		
	}
  
    public int getNumeroPostiTotale() {
        return numeroPostiTotale;
    }

    private void setNumeroPostiTotale() {
    	this.numeroPostiTotale=numeroPostiTotale;
    }
    
    public int getNumeroPostiPrenotati() {
        return numeroPostiPrenotati;
    }
    
    private void setNumeroPostiPrenotati() {
    	this.numeroPostiPrenotati=numeroPostiPrenotati;
    }

    // Metodi prenota, disdici, toString
    public void prenota() throws Exception {
        if (data.before(new Date()) || numeroPostiPrenotati >= numeroPostiTotale) {
            throw new Exception("Impossibile effettuare la prenotazione.");
        }

        numeroPostiPrenotati++;
    }

    public void disdici() throws Exception {
        if (data.before(new Date()) || numeroPostiPrenotati <= 0) {
            throw new Exception("Impossibile effettuare la disdetta.");
        }

        numeroPostiPrenotati--;
    }

    @Override
    public String toString() {
        // Formatta la data come desiderato, ad esempio usando SimpleDateFormat
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormattata = dateFormat.format(data);

        return dataFormattata + " - " + titolo;
    }
}

