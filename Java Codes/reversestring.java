import java.util.*;
import java.io.*;
public class reversestring {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a string ");
        String str = sc.nextLine();

        for(int i = str.length()-1; i>=0; i--)
        {
            System.out.print(str.charAt(i));
        }
    }
}
