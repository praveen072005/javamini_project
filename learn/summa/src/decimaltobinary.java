import java.util.Scanner;
public class decimaltobinary {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(),r=0,bi=0,base=1;
        while(n>0){
            r = n%2;
            bi = bi+r*base;
            n=n/2;
            base = base*10;
        }
        System.out.print(bi+ " ");
        s.close();
    }
}
