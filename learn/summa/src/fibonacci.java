import  java.util.Scanner;
public class fibonacci {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n =s.nextInt(),first=0,last=1,temp=0;
        for(int i=0;i<n;i++){
            System.out.println(first);
            temp =first+last;
            first =last;
            last=temp;
            
        }
        s.close();
    }
}
