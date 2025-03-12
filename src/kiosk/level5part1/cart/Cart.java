package kiosk.level5part1.cart;

import kiosk.level5part1.menu.Item;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> shoppingCart;
    public Cart(){
        shoppingCart = new ArrayList<>();
   }
   //set
    public void setAddShoppingCart(Item Item){
        shoppingCart.add(Item);
        System.out.println(String.format("%s가 장바구니에 추가되었습니다.", Item.getName()));
    }

    //get
    public void getOrderList(){
        for(Item item : shoppingCart)
        {
            System.out.println( String.format("%s      %.1f",item.getName(), item.getPrice()));
        }
    }
    public void  getDiscountShow(){

        for(Discount type : Discount.values())
        {
            System.out.println(String.format("%d. %s       %d%", type.getDiscountNumber(),type.getDiscontName() ,type.getDiscountRate()));
        }
    }
    public double geTotal() {
      double total = 0;
        if (!shoppingCart.isEmpty()) {
            for (Item item : shoppingCart) {
                total += item.getPrice();
            }
        }
        int total;
        return total;
    }

    public int getCount(){
        return shoppingCart.size();
    }


    public  void clearShoppingCart(){
        shoppingCart.clear();
    }

}
