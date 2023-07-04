import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.exit;

public class Menu {



    static HashMap<String, ArrayList<String>> partenze = new HashMap<>();
    static HashMap<String, ArrayList<String>> ritorno = new HashMap<>();
     //arraylist che contiene i viaggiatori contenuti sul file bin
    static ArrayList<Viaggiatore> viaggiatori = new ArrayList<Viaggiatore>();
    static Viaggiatore passeggern = new Viaggiatore();





    public static void main(String[] args) {
        File passeggeri = new File("passeggeri.bin");


        Volo volo1 = new Volo();
        Menu menu = new Menu();
       /* try{
            FileInputStream file = new FileInputStream("passeggeri.bin");
            ObjectInputStream in = new ObjectInputStream(file);
            file.close();
            in.close();

        }catch (Exception e)
        {
            System.out.println(e);
        }*/


        try{
            //File file = new File("pass.bin");
            FileInputStream infile = new FileInputStream("ciaoo.bin");
            ObjectInputStream ins = new ObjectInputStream(infile);

            ins.close();
            infile.close();

        }catch(Exception e){
            System.out.println(e);
        }

        try {//lettura da file di testo delle andate
            FileReader file = new FileReader("andate.txt");
            BufferedReader in = new BufferedReader(file);
            ;
            String riga = in.readLine();
            while (riga != null) {
                //codice per inserimento nell'hasmap
                String[] riga2 = riga.split(" ");
                if (partenze.containsKey(riga2[0])) {
                    ArrayList<String> tmp = partenze.get(riga2[0]);
                    tmp.add(riga2[1]);
                    partenze.put(riga2[0], tmp);
                } else {
                    ArrayList<String> tmp = new ArrayList<>();
                    tmp.add(riga2[1]);
                    partenze.put(riga2[0], tmp);
                }


                riga = in.readLine();
            }

        }catch(IOException e){
            System.out.println(e);
        }
        try{//lettura da fle di testo dei ritorni
            FileReader file1 = new FileReader("ritorni.txt");
            BufferedReader in1 = new BufferedReader(file1);;
            String riga1 = in1.readLine();
            while(riga1 != null)
            {
                //codice per inserimento nell'hasmap
                String[] riga3= riga1.split(" ");
                if(ritorno.containsKey(riga3[0])){
                    ArrayList<String> tmp1 = ritorno.get(riga3[0]);
                    tmp1.add(riga3[1]);
                    ritorno.put(riga3[0],tmp1);
                }else{
                    ArrayList<String> tmp1= new ArrayList<>(); tmp1.add(riga3[1]);
                    ritorno.put(riga3[0],tmp1);
                }


                riga1 = in1.readLine();
            }


        }catch(IOException e){
            System.out.println(e);
        }


    int selezione;
    boolean retroazione = false;
    String control = "no";
        Scanner ing = new Scanner(System.in);
        do {
            System.out.println("****************** SARDINIA-AIRLINES ******************");
            System.out.println("selezionare l'opzione che si desidera eseguire: ");


            System.out.println(" 1: stampa voli: ");
            System.out.println(" 2: stampa lista dei viaggiatori: ");
            System.out.println(" 3: nuova prenotazione ");
            System.out.println(" 4: registrati come viaggiatore ");
            System.out.println(" 5: cercare date in base alla meta");
            System.out.println(" 6: cerca la meta disponibile per una certa data");
            selezione = ing.nextInt();

            while(selezione < 1 || selezione > 6){

                System.out.println("ERRORE!!! \n \n inserire un valore compreso tra 1 e 6");
                selezione = ing.nextInt();

            }

            switch (selezione) {


                case 1:
                    menu.stampaHash(partenze);
                    System.out.println("\n\n");
                    menu.stampaHash(ritorno);
                    break;


                case 2:
                   Viaggiatore pass = new Viaggiatore();
                   viaggiatori = pass.caricaViaggiatori( passeggeri);
                    System.out.println(viaggiatori);
                    menu.stampaPasseggeri();
                    break;

                case 3:


                    System.out.println("benvenuto nella sezione : NUOVA PRENOTAZIONE");
                    // verifico se è un passeggero gia registrato oppure se deve essere ancora registrato
                    System.out.println("inserire codice fiscale : ");
                    String codice;
                    int verify = 0;
                    InputStreamReader input = new InputStreamReader(System.in);
                    BufferedReader tast = new BufferedReader(input);
                    try {

                        codice = tast.readLine();
                        for(Viaggiatore viaggiatore : viaggiatori){
                            if(viaggiatore.getCodiceFiscale().equals(codice)){

                                System.out.println("viaggiatore registrato sulla piattaforma");
                                verify = 1;
                                passeggern = viaggiatore;
                            }
                        }
                        //uso la funzione getviaggiatore che mi restituisce il viaggiatore su cui registrare il volo
                        //passeggern = passeggern.getViaggiatoreCf(codice,viaggiatori);

                    }catch(Exception e){

                        System.out.println(e);

                    }
                    //System.out.println(verify);


                    if(verify != 1){

                        System.out.println("viaggiatore non registrato sulla piattaforma, eseguire una nuova registrazione :");
                        System.out.println("benvenuto nella sezione NUOVA REGISTRAZIONE: ");
                        Viaggiatore passenger1 = new Viaggiatore();


                        passeggern = passenger1.prenotazione();
                        System.out.println(passeggern.toString());
                        viaggiatori.add(passeggern);
                        System.out.println(passeggern);
                        passenger1.salvaViaggiatori(viaggiatori, passeggeri);




                    }

                    System.out.println("desideri visualizzare un volo presente o eseguire una ricerca? : ");
                    Scanner in2 = new Scanner(System.in);
                    System.out.println("1: prenotazione classica \n 2: cerca volo");
                    int selection = in2.nextInt();
                    Volo prenotazione = new Volo();

                    while(selection <1 || selection >2)
                    {
                        System.out.println("ERRORE!!!! inserire un valore compreso tra 1 e 2 !");
                        selection = in2.nextInt();
                    }

                    switch(selection){
                        case 1:
                            menu.stampaHash(partenze);
                            Volo volo = new Volo();
                            System.out.println("inserire aeroporto di partenza e data per cui si vuole prenotare : ");
                            Scanner ins = new Scanner(System.in);

                            System.out.println("aeroporto : ");
                            try{
                                volo.setAeroportoPartenza(ins.nextLine());
                            }catch(Exception e){
                                System.out.println();
                            }

                            System.out.println("data : ");
                            try{
                                volo.setAndata(ins.nextLine());

                            }catch(Exception e){

                                System.out.println();
                            }
                            System.out.println("inserire aeropoporto e data di ritorno");
                            System.out.println("aeroporto : ");
                            try{
                                volo.setAeroportoRitorno(ins.nextLine());

                            }catch(Exception e){
                                System.out.println(e);
                            }
                            System.out.println("data");
                            try{
                                volo.setRitorno(ins.nextLine());

                            }catch(Exception e ) {

                                System.out.println(e);
                            }
                            passeggern.setVoli(volo);

                            System.out.println("\n "+passeggern.voli);
                            System.out.println("\n stampa del biglietto: ");
                            Biglietto biglietto = new Biglietto(passeggern,volo.getAeroportoPartenza(),volo.getAeroportoRitorno(),volo.getAndata(),volo.getRitorno());
                            String s;
                            System.out.println("desideri stampare il biglietto aereo?");
                            s = ins.nextLine();
                            if(s.equals("si")){
                                biglietto.stampaBiglietto();
                            }




                            break;

                        case 2:
                            //prenotazione tramite ricerca del volo


                            break;

                    }
                    break;

                case 4:

                    System.out.println("benvenuto nella sezione NUOVA REGISTRAZIONE: ");
                    Viaggiatore passenger = new Viaggiatore();
                    Viaggiatore app = new Viaggiatore();

                    passenger = app.prenotazione();
                    System.out.println(passenger.toString());
                    viaggiatori.add(passenger);
                    System.out.println(viaggiatori);
                    app.salvaViaggiatori(viaggiatori, passeggeri);


                    break;


                case 5:
                    System.out.println("inserire la data per cui si vuole cercare la meta: ");
                    String meta;
                    String data;
                    Scanner in = new Scanner(System.in);
                    meta = in.nextLine();
                    data = volo1.getData(partenze, meta);
                    if (data == null) {
                        System.out.println("nessuna data trovata per questa meta");
                    } else {
                        System.out.println("trovata almeno una data per : " + data);
                    }
                    break;
                case 6:
                    System.out.println("inserire la data");
                    String meta1;
                    String data1;
                    Scanner in1 = new Scanner(System.in);
                    data1 = in1.nextLine();
                    meta1 = volo1.getMeta(partenze, data1);

                    if(meta1 == null){

                        System.out.println("nessuna meta trovata per questa data");
                    }
                    else{
                        System.out.println("è stata trovat una meta per : "+ meta1);
                    }

            }
            System.out.println("desideri eseguire un altra azione? ");
            System.out.println("inserire si o no:");

            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader tastiera = new BufferedReader(in);

            try{
                control = tastiera.readLine();



            }catch(Exception e){
                System.out.println(e);
            }

            if(control.equals("si")){
                retroazione = true;
            }
            else{
                exit(0);
            }



        }while(retroazione == true);




    try{//scrittura su file binario
        FileOutputStream fileOut = new FileOutputStream("seriale.bin");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(partenze);
        out.writeObject(ritorno);
        out.close();;
        fileOut.close();
    }catch (IOException e){
        System.out.println(e);
    }

  /*  //scrittura viaggiatori su file binario
   try{
        FileOutputStream outfile = new FileOutputStream("passeggeri.bin");
        ObjectOutputStream outs = new ObjectOutputStream(outfile);
        outs.writeObject(viaggiatori);
        outs.close();;
        outfile.close();


    }catch(IOException e){
        System.out.println(e);
        }*/


    }

    //metodo per la stampa dei un hashmap
    public void stampaHash(HashMap map) {

        System.out.println(map);
    }
    //metdo per la stampa dei viaggiatori
    public void stampaPasseggeri() {
        System.out.println(viaggiatori);
    }


}
