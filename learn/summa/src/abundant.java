import java.util.Scanner;
public class abundant {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        int n =s.nextInt(),factor=0,r=0,m=n;
        for(int i=1;i<=n/2;i++){
           r=n%i;
           if(r==0){
            factor+=i;
           }
           }
        if(factor>m){
            System.out.println("abundant number ");
        }else{
            System.out.println("not abundant number");
        }
        
        s.close();
    }
}
