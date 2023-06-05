package tartalom; 

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class tartalom {
    String id;
    String sutiid;
    String mentes;

    public tartalom (String id, String sutiid, String mentes) {
        this.id = id;
        this.sutiid = sutiid;
        this.mentes = mentes;
    }

    @Override
    public String toString() {
        return "tartalma{" + "tartalom id=" + id + ", sutiid=" + sutiid + ", sutitipus=" + tipus + ", sutidijazott=" + dijazott + '}';
    }
    
    

    public static void main(String[] args) throws SQLException {
    ArrayList<tartalom> tartalma = new ArrayList<tartalom>();
      try {
        File file = new File("C:\\Users\\diak\\Desktop\\szm\\06_05dolgozat\\cukraszdasuti.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            String data = scan.nextLine();
            String[] dataSplited = data.split(";");
            tartalom tartalom = new tartalom(dataSplited[0],dataSplited[1],dataSplited[2],dataSplited[3]);
            tartalma.add(tartalom);
        }
        scan.close();
        }
      catch (FileNotFoundException e) {
        System.out.println("File not found");
        e.printStackTrace();
        }
        for (int i = 0; i < tartalma.size(); i++) {
            cukraszda_conect.DBconnect(tartalma.get(i).id, tartalma.get(i).nev, tartalma.get(i).tipus, tartalma.get(i).dijazott);
        }
    }
    
    
}