package kiosk.level2.workOder;

public class MenuItem {
    private  String Category;
    private  int number;
    private  String name;
    private  int price;
    private  String info;

    public MenuItem(int number, String name, int price, String info){
        this.number =number;
        this.name = name;
        this.price =price;
        this.info = info;
    }
    public MenuItem(int number, String name){
        this.number =number;
        this.name = name;
    }


    public int getNumber(){
        return number;
    }
    public String getName(){
        return name;
    }

    public int getPrice(){
        return  price;
    }
    public  String getInfo(){
        return  info;
    }
}
