package kiosk.level5part2.kiosk.cart;

import kiosk.level5part2.kiosk.menu.Item;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> shoppingCart;
    private double discountRate;
    private int totalprice;


    public Cart(){
        shoppingCart = new ArrayList<>();
    }

    /*
     * 2025.03.13
     * 선택한 아이템을 저장합니다.
     * */
    public void setAddItem(Item item){
        shoppingCart.add(item);

    }

    /*
     * 2025.03.13
     * 할인 타입을 받아 서치 찾아서 있으면 true, 없으면 false.
     * */
    public boolean setDiscountRate(int typeNum){
        for(Discount discount : Discount.values()){
            if(discount.getDiscountNumber() == typeNum){
                discountRate =discount.getDiscountRate();
                return  true;
            }
        }
        return false;
    }
    public boolean getDeleteList(String stringInput){
        List<Item>tmpCart = shoppingCart.stream()
                .filter(Item -> Item.getName().equals(stringInput))
                .toList();
        if(!tmpCart.isEmpty())
        {
            for(Item item : tmpCart)
            {
                shoppingCart.remove(item.getId());
            }
            System.out.println("[=======삭제 완료=======]");
            System.out.println("주문을 완료해주세요.");
            return true;
        }
        return false;
    }
    /*
     * 2025.03.13
     * 할인정보를 표시합니다.
     * */
    public void getDiscountList(){
        for (Discount type : Discount.values()) {
            System.out.println(String.format("%-3d %-15s : %3d%% 할인율", type.getDiscountNumber(), type.getDiscontName(), (int) (type.getDiscountRate() * 100)));
        }
    }
    /*
     * 2025.03.13
     * 저장된 아이템의 값을 업데이트 합니다.
     * */
    public int  getTotalprice(){
        for(Item item : shoppingCart){
            totalprice += (item.getPrice() * item.getCount());
        }
        Double discountTotalprice =totalprice * discountRate;
        totalprice = totalprice - discountTotalprice.intValue();
        return totalprice;
    }
    /*
     * 25.03.13
     * 카트안에 담긴 리스트를 출력합니다.
     */
    public  void getOrderList(){

        for(Item item : shoppingCart){
            System.out.println(String.format("%-15s      %3.1f   %5d", item.getName(), (double)item.getPrice()/ 1000, item.getCount()));
        }
    }
    /*
     * 25.03.13
     * Cart 초기화
     */
    public int geCount(){
        return shoppingCart.size();
    }
    /*
     * 25.03.13
     * Cart 초기화
     */
    public void clearShoppingCart() {
        shoppingCart.clear();
    }

}
