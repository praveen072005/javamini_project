import java.util.Scanner;
public class palindrome {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        
        String n = s.next();
        int i=0;
        int j= n.length()-1;
        while(i<j){
            if(n.charAt(i)!=n.charAt(j)){
                System.out.println("not palindrome");

            }
            i++;
            j--;
        }
        System.out.println("palindrome");
        s.close();
    }
    
}
