import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class BeeKeeper {

    private String[] jobs;
    private int indx;
    private ArrayList<String> vowels;
    
    public BeeKeeper(int n){
        this.jobs = new String[n];
        String vowelss = "aaeeiioouuyy";
        this.vowels = new ArrayList<>();
        for(int i = 0; i < vowelss.length();i+=2){
            vowels.add(vowelss.substring(i,i+2));
        }

    }

    public void add(String job){
            jobs[indx] = job;
            indx++;
    }

    public String wantedCareer(){

        String wJob="";
        int mostVowels = 0;

        for(String job:jobs){
            int freqDoubleV= countDoubleVowels(job);
            if(mostVowels < freqDoubleV) {
                wJob = job;
                mostVowels = freqDoubleV;
            }

        } return wJob;
    }

    public int countDoubleVowels(String job){
        int doubleVowel=0;

        for(int i = 0; i < job.length()-1; i++){
            String currentL = job.substring(i,i+2);
            if(vowels.contains(currentL)){
                doubleVowel++;
            }
        } return doubleVowel;
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while(true){

                int N = scanner.nextInt();
                if(N == 0)
                    break;

                BeeKeeper bee = new BeeKeeper(N);

                for(int i = 0; i < N; i++){
                    bee.add(scanner.next());
                }

                    System.out.println(bee.wantedCareer());

            } scanner.close();
    }
}


