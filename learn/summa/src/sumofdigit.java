import java.util.Scanner;
public class sumofdigit {
    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int n = s.nextInt(), r=0;
       while(n>0 || r>9){
        if(n==0){
            n=r;
            n = n%10;
            r +=n;
            n = n/10;
        }
        n=n%10;
        r +=n;
        n=n/10;
       } 
       System.out.println(r);
       s.close();
    }
}
