package com.in28minutes.springboot.machineservices;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SaletaxApplication {


    public static void main(String[] args) throws Exception {
//parsing a CSV file into Scanner class constructor
        Shoppingcart cart = null;
        List<Shoppingcart> cartList = new ArrayList<>();
        String workingDirectory = System.getProperty("user.dir");
        System.out.println("work dir is " + workingDirectory);
        String absoluteFilePath = workingDirectory + File.separator + "SHOPPINGCARTS" + ".csv";

        Reader reader = new FileReader(absoluteFilePath);

        try(LineNumberReader lineNumberReader =
                    new LineNumberReader(reader)){
            String itemname = null;
            int quantity = 0, shoppingbasket = 0, prevshoppingbasket = 0;
            double itemprice = 0.0, salestax = 0.0, importtax = 0.0, totalcost = 0.0;
            int linecount = 0;
            String line = lineNumberReader.readLine();
            while(line != null) {
                //do something with line
            String[] strarr = line.split(",");
                    shoppingbasket = Integer.parseInt(strarr[0]);
                    quantity = Integer.parseInt(strarr[1]);

                      itemname = strarr[2];

                      itemprice = Double.parseDouble(strarr[3]);

                      salestax = Double.parseDouble(strarr[4]);

                      importtax =  Double.parseDouble(strarr[5]);



                if (linecount > 0 && shoppingbasket != prevshoppingbasket ) {
                    display(cartList, shoppingbasket - 1); // take the previous output
                    cartList.clear();
                }
                cart = new Shoppingcart(quantity,itemname,itemprice,salestax,importtax);
                cartList.add(cart);
                line = lineNumberReader.readLine();
                prevshoppingbasket = shoppingbasket;

                ++linecount;
        }
            display(cartList, shoppingbasket);

    }


}

    private static void display(List<Shoppingcart> cartList, int basketnum) {
        double totalsalestax = 0;
        double totalcost = 0.0;
        System.out.println("Output " + basketnum);
        for (Shoppingcart cart : cartList) {

            System.out.printf(cart.getQuantity() + " " + cart.getItemname() + " ");
            System.out.printf("%.2f\n" , cart.getItemtotalcost());
            totalsalestax = totalsalestax + cart.getItemtotalsalestax() ;
            totalcost = totalcost + cart.getItemtotalcost();
        }

        System.out.printf("Sales taxes: " );
        System.out.printf("%.2f\n" , totalsalestax);
        System.out.printf("Total: " );
        System.out.printf("%.2f\n\n" , totalcost);
    }
 }
