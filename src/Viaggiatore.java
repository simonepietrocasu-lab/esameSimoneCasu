import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;


public class Viaggiatore extends Persona implements Serializable{

    Volo voli;





    public Viaggiatore(String nome, String cognome, String sesso, String dataDiNascita, String codiceFiscale) {
        super(nome, cognome, sesso, dataDiNascita, codiceFiscale);
    }



    public boolean ChekIn;

    @Override
    public String toString() {
        return "Viaggiatore{" +
                "nome='" + getNome()+ '\'' +
                ", cognome='" + getCognome() + '\'' +
                ", sesso='" + getSesso()+ '\'' +
                ", dataDiNascita=" + getDataDiNascita() +
                ", codiceFiscale='" + getCodiceFiscale() + '\'' +
                '}';
    }
    //metodo che consente una nuova prenotazione
    public Viaggiatore prenotazione(/*Viaggiatore passeggero*/)
    {
        Viaggiatore passeggero = new Viaggiatore();
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);


        System.out.println("inserire nome e cognome");
        try{
            passeggero.setNome( tastiera.readLine());
            passeggero.setCognome(tastiera.readLine());
        }catch (Exception e)
        {
            System.out.println(e);
        }
        System.out.println("inserire il proprio sesso");
        try{

            passeggero.setSesso(tastiera.readLine());

        }catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("inserire il codice fiscale");
        try{
            passeggero.setCodiceFiscale(tastiera.readLine());

        }catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("inserire la data di nascita");
        try{
            passeggero.setDataDiNascita(tastiera.readLine());
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return passeggero;
    }
    public void faiChekIn (int a){
        if(a == 1){
            ChekIn = true;
        }
        else {
            ChekIn = false;
        }


    }

    public Viaggiatore(String nome, String cognome, String sesso, String dataDiNascita, String codiceFiscale, Volo voli, boolean chekIn) {
        super(nome, cognome, sesso, dataDiNascita, codiceFiscale);
        this.voli = voli;
        ChekIn = chekIn;
    }

    public Viaggiatore(Volo voli, boolean chekIn) {
        this.voli = voli;
        ChekIn = chekIn;
    }

    public Viaggiatore(){

    }

    //metodo che salva i viaggiatori nel file binario, e lo crea nel caso non esista

    public void salvaViaggiatori(ArrayList<Viaggiatore> passeggero, File filename)  {
        if(filename.exists())
        {
            System.out.println("il file: "+ filename + " esiste ");
            try {
                FileOutputStream out = new FileOutputStream(filename);
                ObjectOutputStream outs = new ObjectOutputStream(out);
                outs.writeObject(passeggero);
                outs.close();

            }catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            System.out.println("il file: "+ filename + " non esiste, verrà creato");
            File file = new File("passseggeri.bin");
            try {
                FileOutputStream out = new FileOutputStream(file);
                ObjectOutputStream outs = new ObjectOutputStream(out);
                outs.writeObject(passeggero);
                outs.close();

            }catch(Exception e){
                System.out.println(e);
            }
        }

    }
    //metodo che carica gli oggetti viaggiatori da file binario ad arraylist di viaggiatori
    public  ArrayList<Viaggiatore> caricaViaggiatori(File filename ) {
        if(filename.exists()==true)
        {
            ArrayList<Viaggiatore> a;
            System.out.println("il file: "+ filename +" esiste ");
            try {
                FileInputStream in = new FileInputStream(filename);
                ObjectInputStream ins = new ObjectInputStream(in);
                a = (ArrayList<Viaggiatore>) ins.readObject();
                ins.close();
                return a;


            }catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            System.out.println("file :"+ filename +" non trovato, impossibile eseguire il caricamento");
        }
        return null;
    }

    public Volo getVoli() {
        return voli;
    }

    public void setVoli(Volo voli) {
        this.voli = voli;
    }

    public boolean isChekIn() {
        return ChekIn;
    }

    public void setChekIn(boolean chekIn) {
        ChekIn = chekIn;
    }

    //metodo che controlla se un viaggiatore è presente nell'arraylist di viaggiatori
    public Viaggiatore getViaggiatoreCf(String codiceFiscale, ArrayList<Viaggiatore> viaggiatori){
        Viaggiatore pass = new Viaggiatore();
         for(Viaggiatore a : viaggiatori){
             if(a.getCodiceFiscale().equals(codiceFiscale)){
                 return a;
             }
         }
        System.out.println("nessun viaggiatore con questo codice fiscale");
        pass.setNome("0");
        pass.setCognome("0");
        pass.setSesso("0");
        pass.setCodiceFiscale("0");
        pass.setDataDiNascita("0");
        return pass;

    }

}
