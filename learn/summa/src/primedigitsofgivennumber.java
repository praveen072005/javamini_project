import java.util.Scanner;
public class primedigitsofgivennumber{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(),r=0,reverse=0;
        while(n>0){
            r=n%10;
            if(r==2||r==3||r==5||r==7){
                reverse=reverse*10+r;
            }
            
            n=n/10;
        }
         r=0;
        while(reverse>0){
            r=reverse%10;
            System.out.println(r);
            reverse=reverse/10;

        }
        s.close();
    }
}