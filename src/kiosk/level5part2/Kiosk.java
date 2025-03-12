package kiosk.level5part2;

import kiosk.level5part2.cart.Cart;
import kiosk.level5part2.menu.Item;
import kiosk.level5part2.menu.Menu;
import kiosk.level5part2.util.ValidationCheck;

import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private List<Menu> menus;
    private Menu tempMenu;
    private Item tempItem;


    private Scanner scanner;
    private Cart cart;

    private String command;
    private boolean start = true;




    Kiosk(List<Menu> menus) {
        this.menus = menus;
        this.cart = new Cart();
        this.scanner = new Scanner(System.in);
    }


    public void start() {
        start = true;
        int step = 1;
        while (start) {

            switch (step) {
                case ConstNumber.toMenu:
                    //메뉴
                    step = printCategory();
                    break;
                case ConstNumber.toMenuBoard:
                    //메뉴판
                    step = printMenuList();
                    break;
                case ConstNumber.toOrder:
                    //주문
                    step = orderMenu();
                    break;
                case ConstNumber.toClose:
                    if (cart.getCount() > 0) {
                        step = 3;
                        break;
                    } else {
                        start = false;
                    }
                    break;
                default:
                    System.out.println("없는 주문입니다. 다시 선택해 주세요.");
                    step = 1;
                    break;
            }
        }
        scanner.close();
    }

    private int printCategory() {
        System.out.println("[=======MENU=======]");

        int step = 0;
        int intInput = 0;
        int maxMenu = 0;

        for (Menu menu : menus) {
            System.out.println(menu.getCategoryNum() + ". " + menu.getCategoryName());
            if (maxMenu < menu.getCategoryNum()) {
                maxMenu = menu.getCategoryNum();
            }
        }
        String command = "선택해 주세요:";
        intInput = ValidationCheck.checkCommentInt(command, scanner);

        for (Menu menu : menus) {
            if (menu.getCategoryNum() == intInput) {
                if (menu.getCategoryNum() == 0) {

                    step = ConstNumber.toClose;

                } else if (menu.getCategoryNum() <= maxMenu) {

                    tempMenu = menu;
                    step = ConstNumber.toMenuBoard;

                } else {

                    System.out.println("다시 선택해 주세요.");
                    step = ConstNumber.toMenu;
                }
                break;
            }
        }
        return step;
    }

    private int printMenuList() {
        int step = 0;
        int intInput = 0;
        String command = "";

        System.out.println(String.format("======[ %s Menu]=====", tempMenu.getCategoryName()));
        tempMenu.getShowList();
        command = "선택해 주세요:";
        intInput = ValidationCheck.checkCommentInt(command, scanner);
        tempItem = tempMenu.itemCheck(intInput);
        if (tempItem == null) {
            System.out.println("존재하지 않는 메뉴 입니다. 다시 선택해 주세요.");
            return ConstNumber.toMenuBoard;
        }

        if (Integer.valueOf(0).equals(tempItem.getNumber())) {
            //Back
            step = ConstNumber.toMenu;
        } else if (tempItem.getNumber() <= tempMenu.getMaxItemNum()) {
            command = "개수를 입력해 주세요:\n" +
                    "개수 입력(1이상)      0.취소";
            intInput = ValidationCheck.checkCommentInt(command, scanner);
            if (intInput > 0) {
                tempItem.setCount(intInput);
                cart.setAddShoppingCart(tempItem);
                step = ConstNumber.toMenu;
            }
            else {
                step = ConstNumber.toMenuBoard;
            }
        }
        return  step;
    }

    private int orderMenu() {
        int intInput = 0;
        int step =0;
        System.out.println("[=======Order Menu=======]");
        command = "4.Orders | 장바구니를 확인 후 주문합니다.\n" +
                "5.Cancel |  진행중인 주문을 취소 합니다.";
        intInput = ValidationCheck.checkCommentInt(command, scanner);
        if (intInput == 4) {
            System.out.println("[=======Order=======]");
            System.out.println("아래와 주문 하겠습니까?");
            System.out.println("[Orders]            [Total]  [합계]");
            cart.getOrderList();
            command = "1.주문        2.메뉴판        3.삭제";
           intInput = ValidationCheck.checkCommentInt(command, scanner);
           switch (intInput)
           {
               case 1 :
                  step = cart.selectDiscount(command, scanner);
                  break;
               case 2:
                   step =ConstNumber.toMenuBoard;
                   break;
               case 3:
                   step = cart.deleteCartItem(command, scanner);
                   break;
               default:
                   System.out.println("보기에 없는 기능입니다.");
                   step =  ConstNumber.toOrder;

           }
            return  step;
        }
        else if (intInput == 5) {
            System.out.println("주문이 취소 되었습니다.");
            cart.clearShoppingCart();
            tempMenu =null;
            tempItem = null;

            return ConstNumber.toClose;
        }else {
            System.out.println("보기에 없는 기능입니다.");
            return ConstNumber.toOrder;
        }
    }
}
