package kiosk.level5part1.menu;

public class Item {
    private  String Category;
    private  int number;
    private  String name;
    private  double price;
    private  String info;

    public Item(int number, String name, double price, String info){
        this.number =number;
        this.name = name;
        this.price= price;
        this.info = info;
    }
    public Item(int number, String name){
        this.number =number;
        this.name = name;
    }


    public int getNumber(){
        return number;
    }
    public String getName(){
        return name;
    }

    public double getPrice() {
        return  price;
    }
    public  String getInfo() {
        return  info;
    }
}
