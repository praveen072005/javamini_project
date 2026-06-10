import java.util.Scanner;
public class abc {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        System.out.println("enter the number");
        int n = s.nextInt(),sum=0,r; 
        while(n>0 || sum< 9){
            if(n==0){
                n=sum;
                sum =0;
            }
            r=n%10;
            sum +=r;
            n=n/10;
        }
        System.out.println(sum);
        s.close();
    }
}
