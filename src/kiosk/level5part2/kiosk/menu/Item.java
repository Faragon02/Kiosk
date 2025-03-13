package kiosk.level5part2.kiosk.menu;

public class Item{

    private  int id;
    private  String name;
    private  String info;
    private  int price;
    private  int count;

    public Item(int id, String name, int price,  String info){
        this.id = id;
        this.name = name;
        this.info = info;
        this.price = price;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setCount(int count){
        this.count = count;
    }

    /*
     * 2025.03.13
     * 아이템 아이디를 가져오기
     */
    public int getId(){
        return id;
    }
    /*
     * 2025.03.13
     * 아이템 이름을 가져오기
     */

    public String getName() {
        return name;
    }
    /*
     * 2025.03.13
     * 아이템 정보를 가져오기
     */
    public String getInfo(){
        return info;
    }
    /*
     * 2025.03.13
     * 아이템 값을 가져오기
     */
    public int getPrice(){
        return price;
    }
    /*
     * 2025.03.13
     * 아이템 수량 가져오기
     */
    public int getCount(){
        return count;
    }

}
