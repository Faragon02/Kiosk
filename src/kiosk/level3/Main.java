package kiosk.level3;

import kiosk.level3.kiosk.menu.MenuItem;
import kiosk.level3.kiosk.util.InputCheck;
import kiosk.level3.kiosk.Kiosk;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kiosk kiosk = new Kiosk();
        InputCheck inputCheck = new InputCheck();

        setMenuList( kiosk);
        Start(scanner , kiosk, inputCheck);
    }

    public  static void Start(Scanner scanner, Kiosk kiosk, InputCheck inputCheck){

        int intInput;
        String command;
        boolean start = true;
        System.out.println("================ ======== =MENU= ======== ================ ");
        setMenuList(kiosk);

        while (start) {

            kiosk.getManuList ();
            command = "메뉴를 선택하세요";
            intInput = inputCheck. validationCheck(command, scanner);
            if(intInput == 0){
                System.out.println("프로그램 종료");
                start =  false;
            }
            if(intInput < 4){
                kiosk.getSelectItem(intInput);
            }else {
                System.out.println("존재하지 않는 기능입니다.");
            }
        }
    }


    public  static  void setMenuList(Kiosk kiosk) {

        kiosk.getMenuItem( new MenuItem(1, "ShackBurger" ,6900,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        kiosk.getMenuItem(new MenuItem(2,  "SmokeShak  " ,6900,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        kiosk.getMenuItem(new MenuItem(3,  "CheeseBuger" ,6900,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        kiosk.getMenuItem(new MenuItem(4, "HamBuger   ",6900,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        kiosk.getMenuItem(new MenuItem(0, "종료" ));
    }



}
