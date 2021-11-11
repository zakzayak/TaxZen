package com.zakzayak;

import javax.xml.bind.SchemaOutputResolver;
import java.security.SecureRandom;
import java.util.Scanner;

public class Main {
    static int[] arr;
    static int size = 0;
    static StringBuilder logs;
    public static void main(String[] args) {
	// write your code here
        System.out.println("Enter size of the array");
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        arr = new int[size];
        logs = new StringBuilder();
        logs.append("");

        input();

        start();




    }
    public static void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Chosoe Operations:");
        System.out.println("1 Update single element of array");
        System.out.println("2 Replace All elements");
        System.out.println("3 go back");
        System.out.println("4 Search an elements");

        int choose = sc.nextInt();



        switch (choose) {
            case 1:
                System.out.println("Enter the number to Update");
                logs.append("User want to Update an element");
                int key = sc.nextInt();
                logs.append(key);
                if (update(key))
                    System.out.println("Array successfully updated");
                else {
                    System.out.println("Couldn't found number");
                }
                break;
            case 2:
                System.out.println("Starting replacing all elements");
                for(int i = 0; i <size; i++)
                    arr[i] = 0;
                input();

                break;
            case 3:

                System.exit(0);
                break;

            case 4:
                int x = sc.nextInt();
                logs.append("User searches for ").append(x);
                int pos = search(x);
                if(pos != -1)
                    System.out.println("Found key at " + pos + "th pos");
                else
                    System.out.println("Not found");
                break;
        }

        System.out.println(logs.toString());
    }
    public static void input(){
        Scanner in  = new Scanner(System.in);
        System.out.println("Enter the Numbers");
        int n;
        int i = 0;
        logs.append("Users entered the numbers:");
        while(i < size) {
            n = in.nextInt();
            arr[i] = n;
            logs.append(n);
            logs.append(", ");
            ++i;
        }

    }

    public static int search(int key) {

        for(int i = 0; i< size; i++) {
            if(arr[i] == key) {
                logs.append("Value found key at : ");
                logs.append(i).append("th position");
                return i;
            }
        }
        logs.append("User didn't found key");
        return -1;
    }

    public static boolean update(int key) {
        logs.append("unable to append");
        if(search(key)==-1) return false;

        System.out.println("Enter new Number");
        logs.append(" With new number ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        logs.append(n);

        int i = search(key);
        arr[i] = n;
        logs.append(" Successfully updated ");
        return true;
    }
}
