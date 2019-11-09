import java.util.HashMap;
import java.util.Scanner;

public class DRM {

    HashMap<String, Integer> ABC;
    String sub1;
    String sub2;
    String drmMessage;


    public DRM() {
        ABC = new HashMap<>();
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int indx = 0;
        for (int i = 0; i < 26; i++) {
            ABC.put(abc.substring(indx, indx+1), indx);
            indx++;
        }
    }

    public String getSub1(){
        return sub1;
    }
    public String getSub2(){
        return sub2;
    }

    public void divide(String message) {
        this.sub1 = message.substring(0, (message.length()) / 2);
        this.sub2= message.substring((message.length() - 1) / 2 + 1);
    }

    public int rotateValue(String mess) {

        int rotateValue=0;
        int indx=0;
        for(int i = 0; i < mess.length();i++){
            String letter =mess.substring(indx,indx+1);
            rotateValue += ABC.get(letter);
            indx++;
        }
        return rotateValue;
    }

    public String rotate(int rotateValue,String mess){
        String newString = "";
        int indx = 0;
        for(int i = 0; i < mess.length();i++){
            String letter = mess.substring(indx,indx+1);
            int newValue = (ABC.get(letter) + rotateValue) % 26;
            String newLetter = findLetter(newValue);
            newString = newString + newLetter;
            indx++;
        }
        return newString;
    }

    public String findLetter(int value){

        String Letter="";
        for(String letter:ABC.keySet()){
            if(ABC.get(letter) == value){
                Letter = letter;
                break;
            }
        }return Letter;
    }

    public String merge(String sub1, String sub2){

        int indx = 0;
        String finalString = "";
        for(int i = 0; i < sub1.length();i++){

            int value01 = ABC.get(sub1.substring(indx,indx+1));
            int value02 = ABC.get(sub2.substring(indx,indx+1));

            int newValue = (value01 + value02) % 26;
            finalString = finalString + findLetter(newValue);
            indx++;
        }

        return finalString;
    }



    public static void main(String[] args){
        DRM drm = new DRM();
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()){
            String messg = scanner.nextLine();
            drm.divide(messg);
            int rotateValue01 = drm.rotateValue(drm.getSub1());
            int rotateValue02 = drm.rotateValue(drm.getSub2());
            String rotate01 = drm.rotate(rotateValue01,drm.getSub1());
            String rotate02 = drm.rotate(rotateValue02,drm.getSub2());
            String finalString = drm.merge(rotate01,rotate02);
            System.out.println(finalString);

        }
    }
}
