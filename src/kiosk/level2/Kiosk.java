package kiosk.level2;

import kiosk.level2.io.InputCheck;
import kiosk.level2.workOder.MenuItem;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    public  static  void setMenuList(List<MenuItem> menuList) {

        String[] item = {"ShackBurger",
                "SmokeShak  ",
                "CheeseBuger",
                "HamBuger   ",
                "종료"};
        int[] itemPrice = {6900, 8900, 6900, 5400};
        String[] itemInfo = {"토마토, 양상추, 쉑소스가 토핑된 치즈버거", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", "비프패티를 기반으로 야채가 들어간 기본버거"};
        for (int i = 0; i < item.length; i++) {

            if (item[i] == "종료") {

                menuList.add(new MenuItem(0, "종료"));

            } else {
                menuList.add(new MenuItem(i + 1, item[i], itemPrice[i], itemInfo[i]));
            }
        }
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
            if(intInput >=1){
                getSelectItem(menuList, intInput);
            }else {

                System.out.println("프로그램 종료");
                start =  false;
                break;

            }
        }

    }
}

