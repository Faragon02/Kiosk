package kiosk.level5part2.cart;

import kiosk.level5part2.menu.Item;

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
            System.out.println( String.format("%s      %.1f   %d",item.getName(), item.getPrice(), item.getCount()));
        }
    }
    public void  getDiscountShow(){

        for(Discount type : Discount.values()){
            System.out.println(String.format("%d. %s       %d %", type.getDiscountNumber(), type.getDiscontName(), (int)type.getDiscountRate() * 10));
        }
    }

    public int getTotal() {
      double total = 0;
        if (!shoppingCart.isEmpty()) {
            for (Item item : shoppingCart) {
                total += (item.getPrice() * item.getCount());
            }
        }

        int intTotal = (int)(total * 1000);

        return intTotal;
    }
    public int getCount(){
        return shoppingCart.size();
    }


    public  void clearShoppingCart(){
        shoppingCart.clear();
    }

}
