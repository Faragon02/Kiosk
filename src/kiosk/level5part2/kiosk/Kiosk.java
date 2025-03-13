package kiosk.level5part2.kiosk;

import kiosk.level5part2.kiosk.cart.Cart;
import kiosk.level5part2.kiosk.menu.Menu;
import kiosk.level5part2.kiosk.util.ValidationCheck;
import kiosk.level5part2.kiosk.menu.Item;

import java.util.List;
import java.util.Scanner;

public class Kiosk {

    public final static int toMenu = 1;
    public final static int toMenuBoard = 2;
    public final static int toOrderMenu = 3;
    public final static int toOrders = 4;
    public final static int toDisccount = 5;
    public final static int toDeleteItem = 6;
    public final static int toClose = 0;

    private List<Menu> menus;
    private Menu tempMenu;
    private Item tempItem;
    private Scanner scanner;
    private Cart cart;
    private  String command;
    public Kiosk(List<Menu> menus){
        scanner = new Scanner(System.in);
        cart = new Cart();
        this.menus = menus;
    }

    public  void start(){

        int workStep = toMenu;
        boolean start = true;
        while (start) {

            switch (workStep) {
                case toMenu:
                    //메뉴
                    workStep = printCategory();
                    break;
                case toMenuBoard:
                    //메뉴판
                    workStep = printMenuList();
                    break;
                case toOrderMenu:
                    //주문 옵션 선택
                    workStep= orderMenu();
                    break;
                case  toOrders:
                    //주문?
                    workStep = orders();
                    break;
                case  toDisccount :
                    //할인 적용?
                    workStep = dicountTotal();
                    break;
                case  toDeleteItem:
                    //아이템 삭제
                    workStep = deleteItem();
                    break;
                case toClose:
                    if (cart.geCount()> 0) {
                        workStep = toOrders;
                        break;
                    } else {
                        start = false;
                    }
                    break;
                default:
                    System.out.println("없는 주문입니다. 다시 선택해 주세요.");
                   workStep = toMenu;
                    break;
            }
        }
        scanner.close();

    }

    /* 25. 03. 13
     * 카테고리 선택 화면
     * 정상 선택 하면 다음 스텝으로 이동
     * 없는 선택 하면 현재 스텝을 반복합니다.
     * */
    private int printCategory() {
        int intInput = 0;
        int maxMenu = 0;
        
       while (true){
           System.out.println("[=======MENU=======]");

           for (Menu menu : menus) {
               System.out.println(String.format("%d. %s", menu.getCategoryId(), menu.getCategoryName()));
               if (maxMenu < menu.getCategoryId()) {
                   maxMenu = menu.getCategoryId();
               }
           }
           String command = "선택해 주세요:";
           intInput = ValidationCheck.checkCommentInt(command, scanner);

           for (Menu menu : menus) {
               if (menu.getCategoryId() == intInput) {
                   if(menu.getCategoryId() == 0){
                       return  toClose;
                   }else if(menu.getCategoryId() < maxMenu){
                       tempMenu = menu;
                       return  toMenuBoard;
                   }else{
                       System.out.println("보기에 없는 선택입니다. 다시 선택해주세요.");
                   }
               }
           }
       }
    }
    /* 25. 03. 13
     * 메뉴 선택 화면
     * 정상 선택 하면 개수를 입력합니다.
     * 없으면 현재 스텝을 반복합니다.
     * */
    private int printMenuList() {
        int commandInput = 0;
        String command = "";
        while (true)
        {
            tempMenu.getItemShowList();
            command = "선택해 주세요:";
            commandInput = ValidationCheck.checkCommentInt(command, scanner);
            tempItem = tempMenu.getItem(commandInput);
            if( tempItem != null){
                if(tempItem.getId() == 0){
                   return toMenu;
                }else {
                    command = "개수를 입력해 주세요:\n" +
                            "개수 입력(1이상)      0.취소";
                    commandInput = ValidationCheck.checkCommentInt(command, scanner);
                    if(commandInput != 0){
                        tempItem.setCount(commandInput);
                        cart.setAddItem(tempItem);
                        return toMenu;
                    }else {
                        return toMenuBoard;
                    }
                }
            }else {
                System.out.println("보기에 없는 선택입니다. 다시 선택해주세요.");
            }

        }
    }
    /* 25. 03. 13
     * 메뉴 선택 화면
     * 정상 선택 하면 개수를 입력합니다.
     * 없으면 현재 스텝을 반복합니다.
     * */
    private int orderMenu() {
        int intInput = 0;
        while (true)
        {
            System.out.println("[=======Order Menu=======]");
            command = "4.Orders | 장바구니를 확인 후 주문합니다.\n" +
                    "5.Cancel |  진행중인 주문을 취소 합니다.";
            intInput = ValidationCheck.checkCommentInt(command, scanner);
            if (intInput == 4) {
                return toOrders;
            }
            else if (intInput == 5) {
                System.out.println("주문이 취소 되었습니다.");
                cart.clearShoppingCart();
                tempMenu =null;
                tempItem = null;
                return toClose;
            }else {
                System.out.println("보기에 없는 선택입니다. 다시 선택해주세요.");
            }
        }

    }
    /* 25. 03. 13
     * 주문 선택 화면
     * 정상 선택 하면 다음 스텝으로 이동합니다.
     * 없으면 현재 스텝을 반복합니다.
     * */
    private int orders(){
        int commandInput = 0;
        while (true)
        {
            System.out.println("[=======Order=======]");
            System.out.println("아래와 주문 하겠습니까?");
            System.out.println("[Orders]            [Price]  [Count]");
            cart.getOrderList();
            command = "1.주문        2.메뉴판        3.삭제";
            commandInput = ValidationCheck.checkCommentInt(command, scanner);
            if(commandInput == 1)
            {
                return toDisccount;
            } else if (commandInput == 2 ) {

                return toMenuBoard;

            }else if (commandInput == 3 ) {
                return toDeleteItem;
            }
            else {
                System.out.println("보기에 없는 선택입니다. 다시 선택해주세요.");
            }
        }

    }
    /* 25. 03. 13
     * 할인 선택 화면
     * 정상 선택 하면 선택한 할인을 가격에 적용후 출력 합니다.
     * 없으면 현재 스텝을 반복합니다.
     * */
    private  int dicountTotal(){
        int commandInput = 0;
        while (true)
        {
            cart.getDiscountList();
            command = "선택하세요";
            commandInput = ValidationCheck.checkCommentInt(command, scanner);
            if(cart.setDiscountRate(commandInput)){
                System.out.println("\n주문이 정상적으로 완료 되었습니다. 총 금액은 W" +cart.getTotalprice() + "입니다.");
                cart.clearShoppingCart();
                return  toClose;
            }else {
                System.out.println("보기에 없는 선택입니다. 다시 선택해주세요.");
            }
        }

    }
    /* 25. 03. 13
     * 삭제 입력 화면
     * 정상 입력 하면 일치한 아이템이 있으면 삭제 하고 OrderMenu로 돌아갑니다.
     * 없으면 현재 스텝을 반복합니다.
     * */
    private int deleteItem(){
        String commandInput;
        while (true)
        {
            cart.getDiscountList();
            command = "선택하세요";
            commandInput = scanner.next();
            if(cart.getDeleteList(commandInput)){
                return toOrders;
            }else {
                System.out.println("입력하신거는 주문하신 리스트에 존재하지 않습니다.");
            }
        }
    }
}
