package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    private static String filePath = "vendingmachine.csv";
    File file = new File(filePath);
    Products ObjList = new Products();
    List<Products> items = new ArrayList<>();

    public ReadFile() {
//       run();
    }

    public void run() {

        Products product;

        if (file.exists()) {
            try (Scanner scr = new Scanner(file)) {
                while (scr.hasNextLine()) {

                    String s = scr.nextLine();
                    String[] arr = s.split("\\|");
                    String id = arr[0];
                    String name = arr[1];
                    Double price = Double.parseDouble(arr[2]);
                    String category = arr[3];
                    Integer stock = Integer.parseInt(arr[4]);

                    Products item = new Products(id, name, price, category, stock);
                    item.display();
                    items.add(item);

                }
//                Products ObjList = new Products(items);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }


    }

    public String slogan() {
        return "No item Found";
    }

    public void callObjectList() {
        Products objList = new Products(items);
        String s = objList.getListofItems().get(0).getKey();
        System.out.println(s);

    }
//>>>>>>>> get price

    public Double price(String s) {
        //getting price for each item
        Double price2 = 0.0;
        Products objList = new Products(items);

        for (int i = 0; i < items.size(); i++) {
            String key = objList.getListofItems().get(i).getKey();
            if (key.equalsIgnoreCase(s)) {
                price2 = objList.getListofItems().get(i).getPrice();
                break;
            }
        }
        return price2;
    }

    //  >>>>> get product name

    public String Product(String s) {
        //getting product name
        Products objList = new Products(items);
        String name2 = "";

        for (int i = 0; i < items.size(); i++) {
            String key = objList.getListofItems().get(i).getKey();
            if (key.equalsIgnoreCase(s)) {
                name2 = objList.getListofItems().get(i).getName();
            }
        }

        return name2;
    }

    //>>>>>>>>> update stock

    public void updatestock(String s) {
        Products objList = new Products(items);
        Integer st = 0;
        for (int i = 0; i < items.size(); i++) {
            String key = objList.getListofItems().get(i).getKey();
            if (key.equalsIgnoreCase(s)) {
                st = objList.getListofItems().get(i).getStock();
                objList.getListofItems().get(i).setStock(-1);
            }
        }
        System.out.println(" \n      *** List Of Products ***\n\n");
        for (int j = 0; j < items.size(); j++) {

            objList.getListofItems().get(j).display();
        }
    }
//>>>>> return kind of Product

        public String getcategory(String s) {
            //getting product name
            Products objList = new Products(items);
            String name2 = "";

            for (int i = 0; i < items.size(); i++) {
                String key = objList.getListofItems().get(i).getKey();
                if (key.equalsIgnoreCase(s)) {
                    name2 = objList.getListofItems().get(i).getCategory();
                }
            }

            return name2;
        }
    public String toString(){
      return "No item Found";
    }
}

