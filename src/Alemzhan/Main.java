package Alemzhan;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DBManager db = new DBManager();
        db.connect();
        while(true){
            System.out.println("PRESS [1] TO ADD ITEMS\n" +
                    "PRESS [2] TO LIST ITEMS\n" +
                    "PRESS [3] TO DELETE ITEMS\n" +
                    "PRESS [0] TO EXIT"
                    );
            int choice = in.nextInt();
            if(choice == 1){
                System.out.println("Insert name");
                String name = in.next();
                System.out.println("Insert price");
                double price = in.nextDouble();
                db.additem(new Items(null,name,price));
            }else if(choice == 2){
                ArrayList<Items> items = db.getallItems();
                for(int i = 0;i<items.size();i++){
                    System.out.println(items.get(i).getData());
                }
            }else if(choice == 3){
                System.out.println("Insert id to DELETE: ");
                Long ch = in.nextLong();
                db.deleteitem(ch);
            }else if(choice == 0){
                break;
            }else{
                System.out.println("ERROR!");
                System.out.println("ada");
            }
        }
    }
}
