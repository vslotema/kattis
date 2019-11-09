import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aaah {

    private List<String[]> aaah;

    public Aaah(){
        aaah = new ArrayList<>();
    }

    public void addToList(String[] ah){
        aaah.add(ah);
    }

    public void wasteTime(){

        int Jon = aaah.get(0).length;
        int doctor = aaah.get(1).length;

        if(Jon >= doctor){
            System.out.println("go");
        }else{
            System.out.println("no");
        }

    }

    public int getSize(){
        return aaah.size();
    }

    public static void main(String arg[]){
        Scanner scanner = new Scanner(System.in);
        Aaah ah = new Aaah();
        while(scanner.hasNextLine()){
            String[] aaah = scanner.nextLine().split("");
            ah.addToList(aaah);
            if(ah.getSize() >=2 && ah.getSize()%2==0){
                ah.wasteTime();
            }
        }



    }
}