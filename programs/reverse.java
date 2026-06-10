import java.util.Scanner;
public class reverse{

    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.println("enter the string");
        String b = a.nextLine();
        String c = " ";
        for (int i = b.length()-1;i>=0;i--){
            c +=b.charAt(i);

        };
        System.out.println("reverse string"+c);
        a.close();
        
    }
}

