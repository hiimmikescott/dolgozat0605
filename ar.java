package cukraszda; 

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class cukraszda {
    String id;
    String nev;
    String tipus;
    String dijazott;

    public cukraszda (String id, String nev, String tipus, String dijazott) {
        this.id = id;
        this.nev = nev;
        this.tipus = tipus;
        this.dijazott = dijazott;
    }

    @Override
    public String toString() {
        return "sutik{" + "suti id=" + id + ", sutinev=" + nev + ", sutitipus=" + tipus + ", sutidijazott=" + dijazott + '}';
    }
    
    

    public static void main(String[] args) throws SQLException {
    ArrayList<cukraszda> sutik = new ArrayList<cukraszda>();
      try {
        File file = new File("C:\\Users\\diak\\Desktop\\szm\\06_05dolgozat\\cukraszdasuti.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            String data = scan.nextLine();
            String[] dataSplited = data.split(";");
            cukraszda cukraszda = new cukraszda(dataSplited[0],dataSplited[1],dataSplited[2],dataSplited[3]);
            sutik.add(cukraszda);
        }
        scan.close();
        }
      catch (FileNotFoundException e) {
        System.out.println("File not found");
        e.printStackTrace();
        }
        for (int i = 0; i < sutik.size(); i++) {
            cukraszda_conect.DBconnect(sutik.get(i).id, sutik.get(i).nev, sutik.get(i).tipus, sutik.get(i).dijazott);
        }
    }
    
    
}