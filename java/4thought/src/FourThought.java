import java.util.*;

public class FourThought {

    private Map<Integer, String> fourColl;

    public FourThought(){
        fourColl = new HashMap<>();
    }

    public String setExpression(int a, int b, int c){
        return "4" + setOperator(a) + "4" + setOperator(b) + "4" + setOperator(c) + "4";
    }

    public String setOperator(int a){
        switch (a) {
            case 0:
                return " * ";
            case 1:
                return " + ";
            case 2:
                return " - ";
            case 3:
                return " / ";
        }return null;
    }

    public int Eval(String expression){

        String expr = expression;
        while(expr.contains(" * ")||expr.contains(" / ")){
            expr = calculate("*","/",expr);

        }

        while(expr.contains(" + ")||expr.contains(" - ")){
           expr = calculate("+","-",expr);
        }

        return Integer.parseInt(expr);
    }

    public String calculate(String op1,String op2,String expression){
            String expr = expression;
            String op = op1;
            int op1Indx = expression.indexOf(op1);
            int op2Indx = expression.indexOf(op2);
            int num1IndxStart=op1Indx-2;
            int num1IndxEnd = op1Indx-1;
            int num2IndxStart = op1Indx+2;
            int num2IndxEnd = op1Indx+2;
            int lastIndx = expression.length()-1;

            if(op1Indx ==-1 || (op2Indx<op1Indx && op2Indx!= -1)){
                if(op2.equals("-")) {
                    while (op2Indx != lastIndx && !expression.substring(op2Indx, op2Indx + 2).contains("- ")) {
                        op2Indx++;
                    }
                }
                if(op2Indx!=lastIndx) {
                    num1IndxStart = op2Indx - 2;
                    num1IndxEnd = op2Indx - 1;
                    num2IndxStart = op2Indx + 2;
                    num2IndxEnd = op2Indx + 2;
                    op = op2;
                }
            }
            while(num1IndxStart!=0&&!expression.substring(num1IndxStart-1,num1IndxEnd-1).contains(" ")){
                num1IndxStart--;
            }

            while(num2IndxEnd!=lastIndx&&!expression.substring(num2IndxStart+1,num2IndxEnd+1).contains(" ")){
                num2IndxEnd++;
            }

            int num1 = Integer.parseInt(expression.substring(num1IndxStart,num1IndxEnd));
            int num2;
            if(lastIndx == num2IndxEnd){
                num2 = Integer.parseInt(expression.substring(num2IndxStart));
            }else{
                num2 = Integer.parseInt(expression.substring(num2IndxStart,num2IndxEnd));

            }
        int result = calculate(num1,num2,op);
        expr =newExpression(num1IndxStart,num2IndxEnd,expression,result);

        return expr;
    }


    public String newExpression(int start,int end,String expression,int result){

        if(start != 0){
            String sub1 = expression.substring(0,start);
            if(end == expression.length()-1){
                return sub1 + Integer.toString(result);
            }else{
                String sub3 = expression.substring(end);
                return sub1 + Integer.toString(result) + sub3;
            }

        }else{
            if(end == expression.length()-1){
                return Integer.toString(result);
            }
            String sub2 = expression.substring(end);
            return Integer.toString(result) + sub2;
        }
    }

    public void addToMap(int result, String sum){
            fourColl.put(result, sum);
    }

    public int calculate(int x, int y,String op){
        switch(op) {
            case "*":
                return x * y;
            case "/":
                if (y != 0) {
                    return x / y;
                } else {
                    return -1;
                }

            case "+":
                return x + y;
            case "-":
                return x - y;

        }return -1;
    }



    public void printResult(int n){
        if(fourColl.containsKey(n)){
            String result = fourColl.get(n);
            System.out.println(result + " = " + n);
        }else {
            System.out.println("no solution");
        }
    }

    public Map<Integer, String> getFourColl() {
        return fourColl;
    }

    public static void main(String[] args){

        FourThought ft = new FourThought();

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.nextLine();

        String expression = "";
        for(int a = 0;a<4;a++){
            for(int b = 0;b<4;b++){
                for(int c = 0; c<4;c++){
                    expression = ft.setExpression(a,b,c);
                  //  System.out.println(expression);
                    int key = ft.Eval(expression);
                    ft.addToMap(key,expression);
                }
            }
        }

      /* for(Integer val:ft.getFourColl().keySet()){
            System.out.println(val + " = " + ft.getFourColl().get(val));
        }*/

        for(int i = 0; i < m; i++){
            int n = scanner.nextInt();
            ft.printResult(n);

        }
            scanner.close();


    }

}
