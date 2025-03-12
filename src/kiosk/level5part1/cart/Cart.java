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
            System.out.println( String.format("%-15s      %3.1f   %5d",item.getName(), item.getPrice(), item.getCount()));
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
