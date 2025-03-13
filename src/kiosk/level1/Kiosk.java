package kiosk.level1;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

import java.util.InputMismatchException;

public class Kiosk {


    /*
    * return 입력한 값이 정상적인 Command 숫자인지 확인하는 함수입니ㅏ.
    *
    * */
    static  int checkInt(String command, Scanner scanner)
    {
        int tempInput;
        while (true)
        {
            try
            {
                System.out.println(command);
                tempInput = scanner.nextInt();
                return  tempInput;
            }
            catch (InputMismatchException ex){
                System.out.println("[Exception] 숫자를 입력하세요");
                scanner.nextLine();
            }
        }

    }
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String>menuList =  new ArrayList<>();

        String[] itemBuger = {"ShackBurger",
                         "SmokeShak  ",
                         "CheeseBuger",
                         "HamBuger   ",
                         "종료"};
        double[] itemBugerPrice = {6.9, 8.9,6.9, 5.4};
        String[] itemBugerInfo = {"토마토, 양상추, 쉑소스가 토핑된 치즈버거",
                "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
                "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
                "비프 패티를 기반으로 야채가 들어간 기본버거"};

        int intInput;
        String command;
        boolean start = true;

        for(int i = 0; i< itemBuger.length; i++)
        {

            if(itemBuger[i] == "종료")
            {

                menuList.add("0. 종료");

            }else
            {
                menuList.add(String.format(i+1 + ". %s | W %.1f | %s", itemBuger[i],itemBugerPrice[i], itemBugerInfo[i]));
            }
        }

        while (start)
        {
            System.out.println("========Menu========");
            command = "메뉴를 선택하세요";
            for(int i = 0; i< itemBuger.length; i++)
            {
               System.out.println(menuList.get(i));
            }
            intInput = checkInt(command, scanner);
            if(intInput == 0)
            {
                System.out.println("프로그램을 종료합니다.");
                start = false;
            }else if(intInput <4 )
            {
                System.out.println(menuList.get(intInput -1));

            }else{
                System.out.println("존재하지 않는 기능입니다.");
            }
        }
        scanner.close();
    }
}
