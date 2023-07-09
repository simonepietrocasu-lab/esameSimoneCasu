import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Volo implements Serializable {

    private String aeroportoPartenza;

    private String andata;

    private String aeroportoRitorno;

    private String ritorno;

    private String classe;

    private  int postoAsedere;
    public Volo(){

    }

    public Volo(String aeroportoPartenza, String andata, String aeroportoRitorno, String ritorno) {
        this.aeroportoPartenza = aeroportoPartenza;
        this.andata = andata;
        this.aeroportoRitorno = aeroportoRitorno;
        this.ritorno = ritorno;
    }



    public String getAeroportoPartenza() {
        return aeroportoPartenza;
    }

    public void setAeroportoPartenza(String aeroportoPartenza) {
        this.aeroportoPartenza = aeroportoPartenza;
    }

    public String getAndata() {
        return andata;
    }

    public void setAndata(String andata) {
        this.andata = andata;
    }

    public String getAeroportoRitorno() {
        return aeroportoRitorno;
    }

    public void setAeroportoRitorno(String aeroportoRitorno) {
        this.aeroportoRitorno = aeroportoRitorno;
    }

    public String getRitorno() {
        return ritorno;
    }

    public void setRitorno(String ritorno) {
        this.ritorno = ritorno;
    }


    // metodo che cerca la meta disponibile in base alla data
    public String getMeta (HashMap<String , ArrayList< String>> mappa1, String valore) {
        for(HashMap.Entry<String, ArrayList<String>> entry : mappa1.entrySet()){
          ArrayList<String> listavalori = entry.getValue();
          if(listavalori.contains(valore)){
              return entry.getKey();
          }
        }
        return null;//se non trova nessuna per quel volo restiturisce nullo

    }
    //metodo che passata una meta (key) restituisca la prima data disponibile (valore)
    public String getData (HashMap<String, ArrayList<String>> mappa, String valore) {
        for(HashMap.Entry<String, ArrayList<String>> entry : mappa.entrySet()){
            if(entry.getKey().equals(valore)){
                System.out.println(entry.getValue());
                return valore;
            }

        }
        return null;
    }

    @Override
    public String toString() {
        return "Volo{" +
                "aeroportoPartenza='" + aeroportoPartenza + '\'' +
                ", andata=" + andata +
                ", aeroportoRitorno='" + aeroportoRitorno + '\'' +
                ", ritorno=" + ritorno +
                '}';
    }

    public Volo(String aeroportoPartenza, String andata, String aeroportoRitorno, String ritorno, String classe, int postoAsedere) {
        this.aeroportoPartenza = aeroportoPartenza;
        this.andata = andata;
        this.aeroportoRitorno = aeroportoRitorno;
        this.ritorno = ritorno;
        this.classe = classe;
        this.postoAsedere = postoAsedere;
    }


}
