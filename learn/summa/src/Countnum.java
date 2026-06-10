import java.util.Scanner;
public class Countnum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), count=0;
        while(n>0){
            n=n/10;
            count++;
        }
        System.out.println(count);
        s.close();
    }

    
}
