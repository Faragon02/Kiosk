package kiosk.level3;

import kiosk.level3.kiosk.workOder.MenuItem;
import kiosk.level3.kiosk.io.InputCheck;
import kiosk.level3.kiosk.Kiosk;

import java.util.List;
import java.util.Scanner;


public class Main {

    public  static void Start(Scanner scanner, Kiosk kiosk, InputCheck inputCheck){

        int intInput;
        String command;
        boolean start = true;
        System.out.println("================ ======== =MENU= ======== ================ ");
        setMenuList(kiosk);

        while (start) {

            kiosk.getManuList ();
            command = "메뉴를 선택하세요";
            intInput = inputCheck.checkInt(command, scanner);
            if(intInput >=1){
                kiosk.getSelectItem(intInput);
            }else {

                System.out.println("프로그램 종료");
                start =  false;
                break;

            }
        }
    }


    public  static  void setMenuList(Kiosk kiosk) {

        String[] item = {"ShackBurger",
                "SmokeShak  ",
                "CheeseBuger",
                "HamBuger   ",
                "종료"};
        int[] itemPrice = {6900, 8900, 6900, 5400};
        String[] itemInfo = {"토마토, 양상추, 쉑소스가 토핑된 치즈버거",
                "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
                "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
                "비프패티를 기반으로 야채가 들어간 기본버거"
        };
        for (int i = 0; i < item.length; i++) {

            if (item[i] == "종료") {

                kiosk.getMenuItem(new MenuItem(0,"종료"));

            } else {
                kiosk.getMenuItem(new MenuItem(i + 1, item[i], itemPrice[i], itemInfo[i]));
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kiosk kiosk = new Kiosk();
        InputCheck inputCheck = new InputCheck();

        setMenuList( kiosk);

        Start(scanner , kiosk, inputCheck);
    }
}
