import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TheGame {




    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer> ();   

        Scanner scan = new Scanner(System.in);
        Integer in = scan.nextInt();
        boolean inputEnd = false;
        while (!inputEnd) 
        {
            Integer first = in;
            Integer second = scan.nextInt();
            if (scan.hasNext()) {
                in = scan.nextInt();
            }
            else {
                inputEnd = true;
            }
            list.add(first);
            list.add(second);

        }
        
        System.out.println(list);
    }
}