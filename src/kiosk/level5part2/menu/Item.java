package kiosk.level5part2.menu;

public class Item {
    private  String Category;
    private  int number;
    private  String name;
    private  double price;
    private  int count;
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

    public void setCount(int count){
        this.count = count;
    }

    public int getCount() {return  count;}
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
