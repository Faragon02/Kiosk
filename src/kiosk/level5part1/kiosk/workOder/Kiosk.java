package kiosk.level5part1.kiosk.workOder;

import kiosk.level5part1.kiosk.io.InputCheck;
import kiosk.level5part1.kiosk.workOder.Cart;

import java.util.Scanner;

public class Kiosk {
    public Kiosk(){

    }
    public void Start(Menu menu){

        Scanner scanner = new Scanner(System.in);
        InputCheck inputCheck = new InputCheck();
        Cart cart = new Cart();
        MenuItem item = null;
        int step =0;

        //주문 입력
        int intMenuInput = 0;
        //메뉴판 입력
        int intMenuItemInput = 0;
        //그 외
        int intInput = 0;
        String command;
        boolean start  = true;


        //시나리오
        // 주문에서 입력하여 해당 메뉴판을 본다.
        // 메뉴판을 보고 입력하면 장바구니에 담는다.
        // 장바구니에 추가 후 주문하면 주문한 리스트와 총 합금액을 출력한다.

        //입력 외 번호를 입력하면???
        // 없는 기능을 이라고 통보한다. 이전 스텝에서 대기한다.

        // 구조 if else 문에서 > switch 문으로 변경, step 변수 추가
        // 구조 if 문 존재 할경우 vs Switch 문

        // 변수명 이름 수정 할 것

        // 주문에서 지정된 이상의 번호를 누른다면???

        while (start)
        {
            switch (step)
            {
                case 0:
                    //주문
                    System.out.println("======[Menu]=====");
                    menu.getCategoryName();
                    command = "카테고리를 선택하세요";
                    intMenuInput = inputCheck.checkInt(command, scanner);

                    //입력값이 0보다 크면 주문 판으로 이동
                    //아니면 0프로그램 종료
                    // 입력값이 크면?
                    // => 입력한 값이 리스트 안에 존재 한다면?

                    if(intMenuInput > 0) {

                        step =1;
                    }
                    else{
                        start =false;
                    }
                    break;
                case 1:
                    //메뉴
                    menu.getItemShowList( intMenuInput);
                    command = "선택해주세요.";
                    intMenuItemInput = inputCheck.checkInt(command, scanner);
                    if(intMenuItemInput == 0){
                        step =0;

                    }else if(intMenuItemInput < menu.getListMaxSize()){
                        //List 마다 개수가 다를텐데 입력이 뒤로가기를 제외한것을 선택할수 있게 할 것인가?

                        item = menu.getItemList(intMenuInput).get(intMenuItemInput - 1);
                        System.out.println(String.format("선택한 메뉴: %s |%.1f| %s", item.getName(), (double)item.getPrice() /1000, item.getInfo()));
                        step =2;
                    }else {
                        System.out.println("입력하신 기능은 없습니다. 다시 선택해주세요.");
                        step = 1;
                    }
                    break;
                case 2:
                    // 장바구니

                    System.out.println();
                    System.out.println("장바구니에 추가 하겠습니까?");
                    command = "1.확인            2.취소";
                    intInput = inputCheck.checkInt(command, scanner);
                    if(intInput == 1)
                    {
                        cart.setAddShoppingCart(item);
                        step =3;

                    }else if(intInput == 2) {
                        //주문 메뉴로 돌아간다.
                        step =1;
                    }
                    else {
                        System.out.println("보기에 없는 기능입니다.");
                        //현재 스텝으로 다시 돌아와야 한다.
                        step =2;
                    }

                    break;
                case 3:
                    command = "4.Orders | 장바구니를 확인 후 주문합니다.\n" +
                              "5.Cancel |  진행중인 주문을 취소 합니다.";
                    intInput = inputCheck.checkInt(command, scanner);
                    if(intInput == 4)
                    {
                        System.out.println("아래와 주문 하겠습니까?");
                        System.out.println("[Orders]        [Total]");
                        cart.getOrderList();
                        command = "1.주문        2.메뉴판";
                        intInput = inputCheck.checkInt(command, scanner);
                        if(intInput == 1)
                        {
                            System.out.println();
                            System.out.println("주문이 완료 되었습니다. 총 금액은 W" +cart.geTotal()+ "입니다.");
                            //데이터 초기화
                            cart.clearShoppingCart();
                            step = 0;
                        }
                        else {
                            step = 1;
                        }
                    }
                    else
                    {
                        System.out.println("보기에 없는 기능입니다.");
                        step = 3;
                    }
                    break;

            }

        }
        scanner.close();
    }

}
