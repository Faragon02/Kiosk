package kiosk.level5part2.cart;

import kiosk.level5part2.ConstNumber;
import kiosk.level5part2.menu.Item;
import kiosk.level5part2.util.ValidationCheck;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cart {
    private List<Item> shoppingCart;
    private  int discountMaxNumber;
    public Cart() {
        shoppingCart = new ArrayList<>();

    }

    //set
    public void setAddShoppingCart(Item Item) {
        shoppingCart.add(Item);
        System.out.println(String.format("%s가 장바구니에 추가되었습니다.", Item.getName()));
    }

    //get
    public void getOrderList() {
        for (Item item : shoppingCart) {
            System.out.println(String.format("%-15s      %3.1f   %5d", item.getName(), item.getPrice(), item.getCount()));

        }
    }

    private void getDiscountShow() {

        for (Discount type : Discount.values()) {
            System.out.println(String.format("%-3d %-15s : %3d%% 할인율", type.getDiscountNumber(), type.getDiscontName(), (int) (type.getDiscountRate() * 100)));
            if(discountMaxNumber < type.getDiscountNumber()){
                discountMaxNumber = type.getDiscountNumber();
            }
        }
    }

    public double getDiscontRate(int typeNum) {
        double rate = 0;
        for (Discount type : Discount.values()) {
            if (type.getDiscountNumber() == typeNum) {
               rate = type.getDiscountRate();
            }
        }
        return rate;
    }

    public int getTotal(int typeNum) {
        double total = 0;
        if (!shoppingCart.isEmpty()) {
            for (Item item : shoppingCart) {
                total += (item.getPrice() * item.getCount());
            }
        }
        int intTotal = 0;
        if (typeNum > 0) {

            intTotal = (int) (total * 1000) - (int) (total * 1000 * getDiscontRate( typeNum));

        } else {
            intTotal = (int) (total * 1000);
        }
        return intTotal;
    }

    public int getCount() {
        return shoppingCart.size();
    }
    public void clearShoppingCart() {
        shoppingCart.clear();
    }
    public int getDicountMaxNumber(){
        return discountMaxNumber;
    }


    public int selectDiscount(String command, Scanner scanner){
        int  intInput = 0;
        System.out.println("[=======할인 선택=======]");
        getDiscountShow();
        command = "선택해 주세요:";
        intInput = ValidationCheck.checkCommentInt(command, scanner);
        for (Discount type : Discount.values()) {
            if(type.getDiscountNumber() ==  intInput)
            {
                System.out.println("\n주문이 완료 되었습니다. 총 금액은 W" + getTotal(intInput) + "입니다.");
                //데이터 초기화
                clearShoppingCart();
                return ConstNumber.toClose;
            }
        }
        return ConstNumber.toOrder;
    }
    public  int deleteCartItem(String command, Scanner scanner)
    {
        String stringInput;
        System.out.println("[=======삭제 선택=======]");
        getOrderList();
        command = "선택해 주세요:";
        System.out.println(command);
        stringInput= scanner.next();

       List<Item>tmpCart =shoppingCart.stream()
               .filter(Item -> Item.getName().equals(stringInput))
               .collect(Collectors.toList());

       if(!tmpCart.isEmpty())
       {
           for(Item item : tmpCart)
           {
               shoppingCart.remove(item.getNumber());
           }
           System.out.println("[=======삭제 완료=======]");
           System.out.println("[주문을 완료해주세요.]");
       }
        return ConstNumber.toOrder;
    }
}
