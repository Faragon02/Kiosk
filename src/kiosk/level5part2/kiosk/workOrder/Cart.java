package kiosk.level5part2.kiosk.workOrder;

import kiosk.level5part2.kiosk.io.InputCheck;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart{
    private List<MenuItem> shoppingCart;
    Cart(){
        shoppingCart = new ArrayList<>();
    }

    //set
    public void setAddShoppingCart(MenuItem menuItem){
        shoppingCart.add(menuItem);
        System.out.print("\n");
        System.out.println(String.format("%s가 장바구니에 추가되었습니다", menuItem.getName()));
        System.out.print("\n");
    }

    public void clearShoppingCart() {
        shoppingCart.clear();
    }

    //get
    public  int getCount() {
        return shoppingCart.size();
    }

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
    public void OrderMenu(InputCheck inputCheck, Scanner scanner){

        String command = "4.Orders | 장바구니를 확인 후 주문합니다.\n" +
                "5.Cancel |  진행중인 주문을 취소 합니다.";
        int intInput = inputCheck.checkInt(command, scanner);
        if(intInput == 4) {
            System.out.println("아래와 주문 하겠습니까?");
            System.out.println("[Orders]        [Total]");
            getOrderList();
            command = "1.주문        2.메뉴판";
            intInput = inputCheck.checkInt(command, scanner);
            if (intInput == 1) {
                System.out.println("할인 정보를 입력해주세요.\n" +
                        "1. 국가유공자 : 10% \n" +
                        "2. 군인     :  5%\n" +
                        "3. 학생     :  3%\n" +
                        "4. 일반     :  0%");
                System.out.println("해당하는 조건이 있나요?");
                command = "1.있으면 해당 번호를 입력하세요.\n" +
                        "0.없음";
                intInput = inputCheck.checkInt(command, scanner);
                if (intInput == 0) {
                    //할인 미적용

                    System.out.println(String.format("주문이 완료되었습니다. 금액은 W %.1f",geTotal()));
                } else {
                    //할인 적용
                    RateType rateType = RateType.getRate(intInput);
                    System.out.println(String.format("주문이 완료되었습니다. 금액은 W %.1f",getApplyDiscount(rateType)));
                }

                //데이터 초기화
                clearShoppingCart();
            }

        }
    }
    public double getApplyDiscount(RateType rateType){

        double discountRate =rateType.getRate();
        double total = geTotal();
        total = total - (total * discountRate);
        return total;
    }

}
