package kiosk.Level5lv1.kiosk.workOder;

import kiosk.Level5lv1.kiosk.io.InputCheck;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    public Kiosk(){

    }
    public void Start(Menu menu){

        Scanner scanner = new Scanner(System.in);
        InputCheck inputCheck = new InputCheck();

        int intInput;
        String command;
        boolean start  = true;
        while (start)
        {
            System.out.println("======[Menu]=====");
            menu.getCategoryName();


            command = "카테고리를 선택하세요";
            intInput = inputCheck.checkInt(command, scanner);
            if(intInput > 0) {
                MenuItem item = null;
                menu.getItemList( intInput);


                command = "선택해주세요.";
                intInput = inputCheck.checkInt(command, scanner);
                switch (intInput)
                {
                    case 1:
                        item= menu.getItemListBuger().get(intInput);
                        break;
                    case 2:
                        item = menu.getItemListDesert().get(intInput);
                        break;
                    case 3:
                        item = menu.getItemListDesert().get(intInput);
                        break;
                }
                if(intInput == 0){
                    continue;
                }
                System.out.println(String.format("선택한 메뉴: %s |%.1f| %s", item.getName(), (double)item.getPrice() /1000, item.getInfo()));
                System.out.println();
                System.out.println("장바구니에 추가 하겠습니까?");
                command = "1.확인            2.취소";
                intInput = inputCheck.checkInt(command, scanner);

                if(intInput == 1)
                {
                    menu.setAddShoppingCart(item);

                }else if(intInput == 2) {
                    continue;
                }
                else {
                    System.out.println("보기에 없는 기능입니다.");
                }
            }else
            {
                System.out.println("프로그램 종료");
                start = false;
            }
        }
        scanner.close();
    }

}
