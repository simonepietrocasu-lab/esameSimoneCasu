import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;


public class Biglietto {
    Viaggiatore A;
    String partenza;
    String ritorno;
    String datap,datar;

    int classe;

    int posto;

    int bagaglio;

    public Biglietto(Viaggiatore a, String partenza, String ritorno, String datap, String datar) {
        A = a;
        this.partenza = partenza;
        this.ritorno = ritorno;
        this.datap = datap;
        this.datar = datar;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "-->" + A.toString() +
                ", partenza='" + partenza + '\'' +
                ", ritorno='" + ritorno + '\'' +
                ", datap='" + datap + '\'' +
                ", datar='" + datar + '\'' +
                '}';
    }

    public void stampaBiglietto(){



        //System.out.println(A);
        try {
            File file = new File("biglietto.txt");
            FileWriter fw = new FileWriter(file);

            fw.write("************* SardiniaAirLines **************\n");
            fw.write(A.getNome()+"\n");
            fw.write(A.getCognome()+"\n");
            fw.write(A.getSesso()+"\n");
            fw.write(A.getCodiceFiscale()+"\n");
            fw.write(A.getDataDiNascita()+"\n");
            fw.write(partenza+"\n");
            fw.write(datap+"\n");
            fw.write(ritorno+"\n");
            fw.write(datar+"\n");
            fw.write("*********************************************");
            fw.close();
        }catch (Exception e){
            System.out.println(e);
        }


    }

}
