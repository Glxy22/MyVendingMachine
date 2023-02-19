package com.techelevator.view;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Products {
    private String key;
    private String name;
    private Double price;
    private Integer stock;
    private String category;
      protected  List<Products> productp = new ArrayList<>();

    public Products(){
    }


        public Products(List<Products> product){
        this.productp=product;
 }

    public void setListOfItems(List<Products> products){
        this.productp=products;
    }
    public List<Products> getListofItems(){
        return productp;
    }

    public Products(String key, String name,Double price,String category, Integer stock){
           this.key = key; this.name= name; this.price = price; this.category=category; this.stock = stock;
    }

 public  void display(){

     System.out.printf(" %-10s %-20s %-15s %-15s \n", key, name, price,stock);

 }
public void setStock(Integer st){
    this.stock += st;
}




    public String displayCategory(String s){
        //getting price for each item
        String category2 ="";
        for (int i = 0; i < productp.size(); i++) {
            String key = productp.get(i).getKey();
            if(key.equalsIgnoreCase(s)){
                category2 = productp.get(1).getCategory();
            }
        }
//        System.out.println(productp.get(1).getPrice());
        return category2;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public String getCategory() {
        return category;
    }


}

//    public String displayProduct(String s){
//        //getting price for each item
//        String name2 ="";
//        for (int i = 0; i < productp.size(); i++) {
//            String key = productp.get(i).getKey();
//            if(key.equalsIgnoreCase(s)){
//                name2 = productp.get(i).getName();
//            }
//        }
////        System.out.println(productp.get(1).getPrice());
//        return name2;
//    }
//format to get multiple values from LIST of objects. where one object has multiple values.
//for (Student stu : list<Student>) {
//        for (int i = 0; i < listSpecification.size(); i++) {
//            if (stu.getName().equalsIgnoreCase(listSpecification.get(i))) {
//                data.put(pro.getName(), pro.getValue());
//            }