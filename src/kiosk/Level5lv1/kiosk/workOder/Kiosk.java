package kiosk.Level5lv1.kiosk.workOder;

import kiosk.Level5lv1.kiosk.io.InputCheck;

import java.util.Scanner;

public class Kiosk {
    public Kiosk(){

    }
    public void Start(Menu menu){

        Scanner scanner = new Scanner(System.in);
        InputCheck inputCheck = new InputCheck();

        int intInput;
        String command;
        int step  = 0;
        boolean start  = true;
        while (start)
        {
            command = "카테고리를 선택하세요";
            System.out.println("======[Menu]=====");
            menu.getCategoryName();
            intInput = inputCheck.checkInt(command, scanner);
            if(intInput > 0) {
                switch (intInput) {
                    case 1:

                        //햄버거
                        System.out.println("======[Buger Menu]=====");
                        menu.getItemListBuger();
                        break;
                    case 2:
                        // 음료
                        System.out.println("======[Drink Menu]=====");
                        menu.getItemListDrink();
                        break;
                    case 3:
                        //디저트
                        System.out.println("======[Desert Menu]=====");
                        menu.getItemListDesert();
                        break;

                    default:
                        command = "지원되지 않는 기능입니다.";
                        System.out.println(command);
                        break;
                }

                command = "메뉴를 선택헤주세요";
                intInput = inputCheck.checkInt(command, scanner);
                if(intInput == 0){
                    continue;
                }

            }else
            {
                System.out.println("프로그램 종료");
                start = false;
            }
        }
    }
}
