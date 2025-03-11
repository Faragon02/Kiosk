package kiosk.level5part1.kiosk.workOder;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<MenuItem> shoppingCart;
    Cart(){
        shoppingCart = new ArrayList<>();
    }

    //set
    public void setAddShoppingCart(MenuItem menuItem){
        shoppingCart.add(menuItem);
        System.out.println(String.format("%s가 장바구니에 추가되었습니다.", menuItem.getName()));
    }
    public void clearShoppingCart() {
        shoppingCart.clear();
    }


    //get
    public void getOrderList(){
        for(MenuItem item : shoppingCart)
        {
            System.out.println( String.format("%s      %d",item.getName(), item.getPrice()));
        }
    }
    public double geTotal() {
        double total = 0;
        if (!shoppingCart.isEmpty()) {
            for (MenuItem item : shoppingCart) {
                total += item.getPrice();
            }
        }
        return total;
    }
}
