package kiosk.level2;

import kiosk.level2.util.InputCheck;
import kiosk.level2.menu.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    public static void main(String[] args){

        //Class
        Scanner scanner = new Scanner(System.in);
        InputCheck inputCheck = new InputCheck();
        List<MenuItem> menuList = new ArrayList<>();
        int intInput;
        String command;
        boolean start = true;
        System.out.println("================ ======== =MENU= ======== ================ ");
        setMenuList(menuList);

        while (start) {


            command = "메뉴를 선택하세요";
            getManuList ( menuList);

            intInput = inputCheck.checkInt(command, scanner);
            if(intInput == 0)
            {
                System.out.println("프로그램을 종료합니다.");
                start = false;
            }else if(intInput <4 )
            {
                getSelectItem(menuList, intInput);

            }else{
                System.out.println("존재하지 않는 기능입니다.");
            }
        }
        scanner.close();

    }
    public  static  void setMenuList(List<MenuItem> menuList) {


        menuList.add(new MenuItem(1, "ShackBurger" ,6900,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem(2,  "SmokeShak  " ,6900,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem(3,  "CheeseBuger" ,6900,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem(4, "HamBuger   ",6900,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem(0, "종료" ));

    }


    public static void getManuList (List < MenuItem > menuList)
    {
        for(MenuItem tmepItem : menuList) {
            if(tmepItem.getName() == "종료")
            {
                System.out.println( String.format("%d. %s ", tmepItem.getNumber(), tmepItem.getName()));
            }
            else{
                double tempPrice = (double) tmepItem.getPrice() / 1000;
                System.out.println(String.format("%d. %s | %.1f | %s", tmepItem.getNumber(), tmepItem.getName(),tempPrice , tmepItem.getInfo()));
            }
        }
    }

    public  static  void  getSelectItem(List < MenuItem > menuList, int input)
    {
        //입력한 번호와 동일한 메뉴가 존재하는 지 확인한다.
        for(MenuItem tmepItem : menuList)
        {
            if(tmepItem.getNumber() == input)
            {
                System.out.println("주문 하신 음식이 나왔습니다");
                double tempPrice = (double) tmepItem.getPrice() / 1000;
                System.out.println(String.format(" %s |W %.1f | %s",  tmepItem.getName(),tempPrice , tmepItem.getInfo()));
                System.out.println("==========================================================");
                break;
            }
            else
            {
                System.out.println("해당하는 주문번호는 존재하지 않습니다.");
                System.out.println("==========================================================");
                break;
            }
        }

    }
}

