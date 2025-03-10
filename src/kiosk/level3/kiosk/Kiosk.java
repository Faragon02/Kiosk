package kiosk.level3.kiosk;
import kiosk.level3.kiosk.workOder.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Kiosk {

    List<MenuItem> menuItemList;


    public Kiosk(){
        menuItemList = new ArrayList<>();
    }

    public void getMenuItem(MenuItem item ){
        menuItemList.add(item);
    }
    public void  getSelectItem(int input)
    {
        //입력한 번호와 동일한 메뉴가 존재하는 지 확인한다.
        for(MenuItem tmepItem : menuItemList)
        {
            if(tmepItem.getNumber() == input)
            {
                System.out.println("주문 하신 음식이 나왔습니다");
                double tempPrice = (double) tmepItem.getPrice() / 1000;
                System.out.println(String.format(" %s | %.1f | %s", tmepItem.getName(),tempPrice , tmepItem.getInfo()));
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
    public  void getManuList ()
    {
        for(MenuItem tmepItem : menuItemList) {
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

}

