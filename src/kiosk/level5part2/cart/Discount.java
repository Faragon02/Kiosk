package kiosk.level5part2.cart;

public enum Discount {
    NationalMerit(1, 1, "국가 유공자"),
    Soldier(2, 0.5,"군인"),
    Student(3, 0.3, "학생"),
    ReqularCustomer(4,0, "일반인");

    private final int number;
    private final String name;
    private final double rate;
    Discount(int number, double rate, String name){
        this.number = number;
        this.name = name;
        this.rate = rate;
    }
    public  double getDiscountRate(){
        return rate;
    }
    public int getDiscountNumber(){
        return number;
    }
    public String getDiscontName(){
        return name;
    }
}
