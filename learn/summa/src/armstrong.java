import java.util.Scanner;
public class armstrong {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n =s.nextInt(),count=0,m=n,result=1, sum=0;
        while(n>0){
            n=n/10;
            count++;

        }
        n=m;
        int r =0;
        while(n>0){
            r=n%10;
            for(int i=0;i<count;i++){
                result = result*r;
            }
            sum +=result;
            result =1;
            n=n/10;
        }
        if(m == sum){
            System.out.println("armstrong");
        }else{
            System.out.println("not armstrong");
        }
        s.close();
    }
}
