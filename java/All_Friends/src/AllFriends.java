import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllFriends {

    private int count;
    private int indxM;
    private int indxN;
    private ArrayList<FriendGroup>[] groups;


    public AllFriends(int n){

        this.count=0;
        this.groups = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            groups[i] = new ArrayList<>();
        }
    }

    public void union(int n,int m) {

        ArrayList<FriendGroup> N = groups[n];
        ArrayList<FriendGroup> M = groups[m];

        if (N.size() == 0 && M.size() == 0) {
            createNewGroup(n, m, N, M);

        } else {

            if (findCommonFriends(N, M, m)) {
                M.remove(indxM);
                N.get(indxN).getList().add(m);
                M.add(N.get(indxN));
                return;
            } else {
                createNewGroup(n, m, N, M);
            }
        }
    }


    public boolean findCommonFriends(ArrayList<FriendGroup> N, ArrayList<FriendGroup>M,int n) {
        this.indxM = 0;
        this.indxN = 0;
        boolean commonFriends = false;
        for (FriendGroup group : N) {
            if (!M.contains(group)) { //check if union is redundant


                        for (int i = 0; i < M.size(); i++) {
                            for (Integer personM : M.get(i).getList()) {
                                if(!group.getList().contains(personM)){
                                   commonFriends = false;
                                   indxM =0;
                                   break;
                                }else if(group.getList().contains(personM) || personM ==n && indxM == M.get(i).getSize()-1){
                                    return true;
                                }else{
                                    indxM++;
                                }

                            }
                        }
                        indxN++;
                    }

            }
            return commonFriends;
        }

    public void createNewGroup(int n, int m,ArrayList<FriendGroup> N, ArrayList<FriendGroup>M){
        FriendGroup newGroup = new FriendGroup();
        newGroup.getList().add(n);
        newGroup.getList().add(m);
        M.add(newGroup);
        N.add(newGroup);
        count++;
    }

    public int getCount(){
        return count;
    }

    public class FriendGroup{

        private List<Integer> members;

        public FriendGroup(){
            this.members = new ArrayList<>();
        }

        public int getSize(){
            return members.size();
        }

        public List<Integer> getList(){
            return members;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        AllFriends friends = new AllFriends(n);
        for(int i = 0; i < m; i++){
            friends.union(scanner.nextInt(),scanner.nextInt());
        }
        int max = friends.getCount();
        if(max > 1000){
            System.out.println("Too many maximal sets of friends.");
        }else{
            System.out.println(max);
        }

    }
}
