package com.hakaryzhang.hello;


public class HelloWorld extends Test{

    public static void main(String[] args) {
        /*
        * Lambda Expression Example
        * */

        CakeFactory cakeFactory = new CakeFactory("Cup Cake");
        double money = 10.0;

        // Java original type
        Cake cake = cakeFactory.buyCake(money, new MoneyChecker() {
            @Override
            public boolean checkMoney(double money) {
                System.out.println("----- Self-service Checkout -----");
                return money > 5.0;
            }
        });
        System.out.println("Now we got a " + cake.name() + "!\n");


        // Lambda expression
        cake = cakeFactory.buyCake(money, m -> {
            System.out.println("----- Self-service Checkout -----");
            return m > 5.0;
        });
        System.out.println("Now we got a " + cake.name() + "!\n");


        // Send a static method as parameter
        cake = cakeFactory.buyCake(money, Cashier::moneyChecker);
        System.out.println("Now we got a " + cake.name() + "!\n");


        // Send an instance method as parameter
        cake = cakeFactory.buyCake(money, cakeFactory::CheckMoneyAuto);
        System.out.println("Now we got a " + cake.name() + "!\n");


        // Send a structure method as parameter (No Example)

    }

    @FunctionalInterface
    interface MoneyChecker {
        boolean checkMoney(double money);
    }

    static class Cashier {
        public static boolean moneyChecker(double money){
            System.out.println("----- Cashier Checking -----");
            return money > 5.0;
        }
    }

    static class CakeFactory {
        private final String cakeName;

        public CakeFactory(String cakeName) {
            this.cakeName = cakeName;
        }

        public Cake buyCake(double money, MoneyChecker checker){
            if (checker.checkMoney(money)){
                System.out.println("Sure, this is your cake!");
                return new Cake(cakeName);
            }
            else{
                System.out.println("Sorry, money not enough.");
                return new Cake("Null");
            }
        }

        public boolean CheckMoneyAuto(double money){
            System.out.println("----- Auto Machine Checking -----");
            return money > 5.0;
        }

    }

    record Cake(String name) {
    }



}


