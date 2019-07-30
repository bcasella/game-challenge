

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class TheGame {




    public static void main(String[] args) {

        List<Property> properties = new ArrayList<Property> ();   

        Scanner scan = new Scanner(System.in);
        Integer in = scan.nextInt();
        boolean inputEnd = false;
        while (!inputEnd) 
        {
            Integer value = in;
            Integer rent = scan.nextInt();
            Property property = new Property(value,rent);
            if (scan.hasNext()) {
                value = scan.nextInt();
            }
            else {
                inputEnd = true;
            }
            properties.add(property);

        }
        
        System.out.println(properties);
    }
}