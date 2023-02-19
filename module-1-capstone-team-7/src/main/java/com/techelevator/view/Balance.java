package com.techelevator.view;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public class Balance extends Products {

    private Double balance = 0.0;
    private Double remainingBalance=0.0;
   private Double price=0.0;
//    BigDecimal num = new BigDecimal("0.00");

    public Balance(){
        this.price=super.getPrice();

            }
//            public Balance(int balance,Double remainingBalance){
//
//            }

            public Double getbalanace(Double balance) {
                if (balance >= 0) {
                    this.balance += balance;
                } else
                    System.out.println("\n Deposit Money Before Making a Purchase!!\n ");
                return this.balance;
            }

            public BigDecimal getchange(Double s){
                BigDecimal number = new BigDecimal(0);
                 this.balance = this.balance - s;
                 if(this.balance<=0)
                     System.out.println(">>> Make Deposit to Continue Purchase!!");
                else
                     number = new BigDecimal(this.balance);


                 return number;


            }
}
