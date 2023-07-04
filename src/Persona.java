import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Persona implements Serializable {
    private String nome;

    private String cognome;

    private String sesso;

    private String dataDiNascita;

    private String codiceFiscale;

    public Persona(String nome, String cognome, String sesso, String dataDiNascita, String codiceFiscale) {
        this.nome = nome;
        this.cognome = cognome;
        this.sesso = sesso;
        this.dataDiNascita = dataDiNascita;
        this.codiceFiscale = codiceFiscale;
    }
    public Persona(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    //metodo che calcola l'eta di un viaggiatore (persona)

    public int eta(Viaggiatore passeggero){

        LocalDate oggi = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate nascita = LocalDate.parse(passeggero.getDataDiNascita() , formatter );
        Period periodo = Period.between(nascita, oggi);
        return  periodo.getYears();

    }

}
