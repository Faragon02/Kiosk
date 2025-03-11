package kiosk.level5part2.kiosk.workOrder;
import kiosk.level5part2.kiosk.io.InputCheck;
import kiosk.level5part2.kiosk.workOrder.Cart;
import java.util.Scanner;

public class Kiosk {
    public Kiosk(){

    }
    public void Start(Menu menu){

        Scanner scanner = new Scanner(System.in);
        InputCheck inputCheck = new InputCheck();
        Cart cart = new Cart();

        RateType rateType = null;
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

        //주문
        //메뉴판 보기
        //주문?
        // 장바구니에 물건이 들어 있으면 아래와 같이 [ ORDER MENU ] 가 추가로 출력됩니다.
        // 만약에 장바구니에 물건이 들어 있지 않다면 [ ORDER MENU ] 가 출력되지 않습니다.
        //주문 -> 종료? 장바구니 내 물건 계산? 프로그램 종료



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
                    if(intMenuInput  != 0 && intMenuInput < 4)
                    {
                        step = 1;
                    }
                    else if(intMenuInput == 0)
                    {
                        if(cart.getCount() >= 1)
                        {
                            cart.OrderMenu(inputCheck, scanner);
                        }
                        start =false;
                    }

                     break;
                 case 1:
                     menu.getItemShowList( intMenuInput);
                     command = "선택해주세요.";
                     intMenuItemInput = inputCheck.checkInt(command, scanner);
                     if(intMenuItemInput == 0){
                         step =0;
                     }
                     item = menu.itemCheck(intMenuInput ,  intMenuItemInput);
                     if(item != null)
                     {
                         System.out.println(String.format("선택한 메뉴: %s |%.1f| %s", item.getName(), (double)item.getPrice() /1000, item.getInfo()));
                         step =2;
                     }
                     else
                     {
                         System.out.println("입력하신 메뉴는 없습니다. 다시 선택해주세요.");
                         step = 1;
                     }
                     break;
                 case 2:
                     System.out.println();
                     System.out.println("장바구니에 추가 하겠습니까?");
                     command = "1.확인            2.취소";
                     intInput = inputCheck.checkInt(command, scanner);
                     if(intInput == 1)
                     {
                         cart.setAddShoppingCart(item);
                         step =0;

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
                 default:
                     System.out.println("주문에는 없는 선택입니다.");
                     step =1;
                     break;
             }
        }
        scanner.close();
    }

}
