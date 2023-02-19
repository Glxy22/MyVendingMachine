package com.techelevator;

import com.techelevator.view.*;

import java.io.*;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String MAIN_MENU_SECRET_OPTION = "*Sales Report";

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_SECRET_OPTION};
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

    private VendingMenu menu;


    public VendingMachineCLI(VendingMenu menu) {
        this.menu = menu;
    }

    public void run() throws IOException {
        boolean running = true;
        ReadFile var = new ReadFile();
        ReadFile candy = new Candy();
        ReadFile chips = new Chips();
        ReadFile gum = new Gum();
        ReadFile drink = new Drinks();
        Double balance = 0.0;
        BigDecimal change = new BigDecimal("0.00");
        String slogan ="";
        String c = "";
       // Products var2 = new Products();


        File log = new File("Log.txt");
//		log.createNewFile();

        Balance bal = new Balance();
        Scanner scr = new Scanner(System.in);
        Double amount = 0.0;
//        var.run();
        SimpleDateFormat dateTime = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
        String date = dateTime.format(new Date());
        while (running) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            // A switch statement could also be used here.  Your choice.
            switch (choice) {
                case MAIN_MENU_OPTION_DISPLAY_ITEMS:
                    System.out.println(" \n      *** List Of Products ***\n\n");
                   System.out.println("\033[0;1m" + " ID         PRODUCTS             PRICE\n\n");
                   var.run();
                    break;
                case MAIN_MENU_OPTION_PURCHASE:
                    choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
                    break;
                case MAIN_MENU_OPTION_EXIT:
                    System.out.println("\nPlease collect your change: $" + c);
                    System.out.println(" \n*** GOOD BYE!!  ***");
                    running = false;
                    break;
            }

            switch (choice) {
                //Balanace Calculation

                case PURCHASE_MENU_OPTION_FEED_MONEY:
                    System.out.println("\n Add the money...in whole dollar amount..(ex10)");
                    try {
                        amount = Double.parseDouble(scr.nextLine());

                        balance = bal.getbalanace(amount);
                    } catch (Exception e) {
                        System.out.println("\n Deposit Money to Make a Purchase \n");

                    }

                    System.out.println("Your balance is : " + balance);

                    try (PrintWriter writer = new PrintWriter(new FileOutputStream(log, true))) {

                        writer.println(date + " FEED MONEY: $" + amount + " Your new balance : $" + balance);

                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;

                case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
                    System.out.println(" \n      *** List Of Products ***\n\n");
                    System.out.println("\033[0;1m" + " ID         PRODUCTS             PRICE\n\n");
                    var.run();
                    System.out.println("\n*** Please Choose a Product ***\n");
                    String key = scr.nextLine().toLowerCase();

//  Stock update>>>>>???

                    Double productPrice = var.price(key);               //>>>>>>>>
                                   var.updatestock(key);
//


                    if (balance > 0) {
// Calculating Change >>>>>

                        change = bal.getchange(productPrice);
                         c = NumberFormat.getCurrencyInstance().format(change);
                        System.out.println("\n\n >>>> Your balance was : " + balance + " >>>> Your Change is : " + c + "\n");

                        String nameOfProduct = var.Product(key);             //>>>>>>>>>

                        try (PrintWriter writer = new PrintWriter(new FileOutputStream(log, true))) {

                            writer.println(date + " " + nameOfProduct + " " + key + " $" + productPrice + " Your change : $" + c);

                        } catch (Exception e) {
                            e.getMessage();
                        }


                    } else {
                        System.out.println("\n Deposit Money to Make a Purchase>>> \n");
                    }


                    //Slogan >>>>>>>

                    if (balance != 0) {
                     String category= var.getcategory(key);
                        if (var.getcategory(key).equalsIgnoreCase("Candy")) {
                            slogan = candy.toString();
                            System.out.println(slogan);
                        } else if (category.equalsIgnoreCase("Chip")) {
                            slogan = chips.toString();
                            System.out.println(slogan);
                        } else if (category.equalsIgnoreCase("Gum")) {
                            slogan = gum.toString();
                            System.out.println(slogan);
                        } else if (category.equalsIgnoreCase("Drink")) {
                            slogan = drink.toString();
                            System.out.println(slogan);
                        }
                    }


                    break;


                case PURCHASE_MENU_OPTION_FINISH_TRANSACTION:
                    System.out.println("\nPlease collect your change: $" + c);
                    System.out.println(" \n *** GOOD BYE!!  ***");
                    running = false;
                    break;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        VendingMenu menu = new VendingMenu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }
}
