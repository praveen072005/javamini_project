import java.util.Scanner;
public class reverse {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), r=0,reverse1=0;
        while(n>0){
            r = n%10;
            reverse1 =reverse1*10+r; 
            n=n/10;
        }
        System.out.println(reverse1);
        s.close();
    }

}
