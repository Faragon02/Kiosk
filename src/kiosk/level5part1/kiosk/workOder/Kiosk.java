package kiosk.level5part1.kiosk.workOder;

import kiosk.level5part1.kiosk.io.InputCheck;

import java.util.Scanner;

public class Kiosk {
    public Kiosk(){

    }
    public void Start(Menu menu){

        Scanner scanner = new Scanner(System.in);
        InputCheck inputCheck = new InputCheck();

        MenuItem item = null;
        int step =0;
        int intInput = 0;
        String command;
        boolean start  = true;

        // 구조 if문에서 > switch문으로 변경, step 변수 추가
        // 변수명이름 수정 할 것

        while (start)
        {
            switch (step)
            {
                case 0:
                    System.out.println("======[Menu]=====");
                    menu.getCategoryName();
                    command = "카테고리를 선택하세요";
                    intInput = inputCheck.checkInt(command, scanner);
                    if( intInput > 0){

                        step =2;
                    }
                    else
                    {
                        step = 0;
                    }


                    break;
                case 1:

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
                        case 0:
                            step =1; //Back
                            break;
                    }


                    break;
                case 2:
                    break;
                case 3:
                    break;
            }

            if(step !=0)
            {
                if(step == 1)
                {
                    //메뉴 선택
                    System.out.println("======[Menu]=====");
                    menu.getCategoryName();
                    command = "카테고리를 선택하세요";
                    intInput = inputCheck.checkInt(command, scanner);
                    step =2;


                } else if (step == 2 && intInput > 0) {
                    //메뉴 상세 선택

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
                        case 0:
                            step =1; //Back
                            break;
                    }


                } else if (step == 3) {
                    // 장바구니
                    System.out.println(String.format("선택한 메뉴: %s |%.1f| %s", item.getName(), (double)item.getPrice() /1000, item.getInfo()));
                    System.out.println();
                    System.out.println("장바구니에 추가 하겠습니까?");
                    command = "1.확인            2.취소";
                    intInput = inputCheck.checkInt(command, scanner);
                    if(intInput == 1)
                    {
                        menu.setAddShoppingCart(item);
                        step =4;

                    }else if(intInput == 2) {
                        //추가 없이 현재 스텝으로 다시 돌아와야 한다.
                        step =3;
                    }
                    else {
                        System.out.println("보기에 없는 기능입니다.");
                        //현재 스텝으로 다시 돌아와야 한다.
                        step =3;
                    }

                } else if (step == 4) {
                    command = "4.Orders | 장바구니를 확인 후 주문합니다.\n" +
                             " 5.Cancle |  진행중인 주문을 취소 합니다.";
                    intInput = inputCheck.checkInt(command, scanner);

                    command = "1.주문        2.메누판";
                    intInput = inputCheck.checkInt(command, scanner);
                }


            }
        }
        scanner.close();
    }

}
