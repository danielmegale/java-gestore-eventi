package org.java.gestore_eventi;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class Concerto extends Evento {

	private LocalTime ora;
	private BigDecimal prezzo;	
	
	public Concerto(String titolo, Date data, int numeroPostiTotale,LocalTime ora,BigDecimal prezzo) throws Exception {
		super(titolo, data, numeroPostiTotale);
		this.ora=ora;
		this.prezzo=prezzo; 
	}

	public LocalTime getOra() {
		return ora;
	}

	private void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	private void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	
	// Metodi per restituire data e ora formattata e prezzo formattato
	public String getFormattedDataOra() {
		  return String.format("%02d:%02d", ora.getHour(), ora.getMinute());
	}

    public String getFormattedPrezzo() {
        DecimalFormat decimalFormat = new DecimalFormat("##,##€");
        return decimalFormat.format(calcolaTotale());
    }
    
    public BigDecimal calcolaTotale() {
        return prezzo.multiply(BigDecimal.valueOf(getNumeroPostiPrenotati()));
    }


    @Override
    public String toString() {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	String dataFormattata = dateFormat.format(getData());
    	return dataFormattata + " " + getFormattedDataOra() + " - " + getTitolo() + " - " + getFormattedPrezzo();
    }

}
