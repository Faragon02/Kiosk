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

    private final static int toMenu =1;
    private final static int toMenuBoard =2;
    private final static int toOrder =3;
    private final static int toClose =0;



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
                case 1:
                    //메뉴
                    step = printCategory();
                    break;
                case 2:
                    //메뉴판
                    step = printMenuList();
                    break;
                case 3:
                    //주문
                    step = orderMenu();
                    break;
                case 0:
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
                    step = 0;
                } else if (menu.getCategoryNum() > 0 && menu.getCategoryNum() <= maxMenu) {

                    step = toMenuBoard;
                } else {
                    System.out.println("다시 선택해 주세요.");
                    step = toMenu;
                }
                tempMenu = menu;
                break;
            }
        }
        return step;
    }

    private int printMenuList() {

        System.out.println(String.format("======[ %s Menu]=====", tempMenu.getCategoryName()));
        int step = 0;
        int intInput = 0;
        String command = "";

        tempMenu.getShowList();
        command = "선택해 주세요:";
        intInput = ValidationCheck.checkCommentInt(command, scanner);
        tempItem = tempMenu.itemCheck(intInput);
        if (tempItem == null || tempItem.getNumber() == 0) {
            //Back
            step =toClose;
        } else if (tempItem.getNumber() > 0 && tempItem.getNumber() <= tempMenu.getMaxItemNum()) {
             command = "개수를 입력해 주세요:\n" +
                       "개수 입력(0이상)      2.취소";
             intInput = ValidationCheck.checkCommentInt(command, scanner);
             if(intInput > 0){
                 tempItem.setCount(intInput);
                 cart.setAddShoppingCart(tempItem);
                 step =toMenu;
             }
             else{
                 step = toMenuBoard;
             }
        } else {
            System.out.println("존재하지 않는 메뉴 입니다. 다시 선택해 주세요.");
            step =toMenuBoard;
        }

        return step;
    }

    private int orderMenu() {
        int intInput = 0;
        command = "4.Orders | 장바구니를 확인 후 주문합니다.\n" +
                "5.Cancel |  진행중인 주문을 취소 합니다.";
        intInput = ValidationCheck.checkCommentInt(command, scanner);
        if (intInput == 4) {
            System.out.println("아래와 주문 하겠습니까?");
            System.out.println("[Orders]        [Total]  [합계]");
            cart.getOrderList();
            command = "1.주문        2.메뉴판";
            intInput = ValidationCheck.checkCommentInt(command, scanner);
            if (intInput == 1) {
                System.out.println("\n주문이 완료 되었습니다. 총 금액은 W" + cart.getTotal() + "입니다.");
                //데이터 초기화
                cart.clearShoppingCart();
                //프로그램 종료
                return  toClose;
            } else {
                //메뉴판
                return toMenu;
            }
        } else if (intInput == 5) {
            //주문
            return toMenu;
        } else {
            //현재스텝 재시작
            System.out.println("보기에 없는 기능입니다.");
            return toOrder;
        }
    }
}
