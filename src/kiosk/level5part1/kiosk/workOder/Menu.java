package kiosk.level5part1.kiosk.workOder;

import java.util.ArrayList;
import java.util.List;


public class Menu {
    //속성
    private int maxMenuListSize;
    private List<String> categoryItemList;
    private List<MenuItem> menuItemListBuger;
    private List<MenuItem> menuItemListDrink;
    private List<MenuItem> menuItemListDesert;


    //생성자
    public Menu() {

        categoryItemList = new ArrayList<>();
        menuItemListBuger = new ArrayList<>();
        menuItemListDrink = new ArrayList<>();
        menuItemListDesert = new ArrayList<>();
    }

    //set
    public void setCategoryItemList(String[] item){
        for(String tempitem : item)
        {
            categoryItemList.add(tempitem);
        }
    }
    public void setmenuItemListBugerList(MenuItem item){

        menuItemListBuger.add(item);
    }
    public void setmenuItemListDrinkList(MenuItem item){
          menuItemListDrink.add(item);
    }
    public void setMenuItemListDesertList(MenuItem item){
        menuItemListDesert.add(item);
    }


    //get
    public void getCategoryName(){
       int i =0;
        for(String tempitem :categoryItemList)
        {
            if(tempitem == "종료")
            {
                System.out.println( 0 + ".종료");
            }
            else
            {
                System.out.println( i+1 + "." + tempitem);
            }
            i++;
        }
    }
    public  void  getItemShowList(int categoryNum){
        List<MenuItem> tmepItemList;

         if(categoryNum >3) {
             System.out.println("지원되지 않는 기능입니다.");
         }

         if(categoryNum  ==1 )
         {
             System.out.println("======[Buger Menu]=====");
             tmepItemList = menuItemListBuger;
         }
         else if(categoryNum ==2)
         {
             System.out.println("======[Drink Menu]=====");
             tmepItemList = menuItemListDrink;
         }
         else {
             System.out.println("======[Desert Menu]=====");
             tmepItemList = menuItemListDesert;
         }
        maxMenuListSize = tmepItemList.size();
        for(MenuItem item :tmepItemList)
        {
            if(item.getName() == "Back")
            {
                System.out.println(item.getNumber() + "."  + item.getName());
            }
            else {
                System.out.println(String.format("%d. %s | w %.1f| %s", item.getNumber(),item.getName(), (double)item.getPrice() /1000, item.getInfo()));
            }

        }

    }

    public  List<MenuItem> getItemList(int SelectNum){
        List<MenuItem> tmepItemList;

        if(SelectNum  ==1 )
        {
            tmepItemList = menuItemListBuger;
        }
        else if(SelectNum ==2)
        {
            tmepItemList = menuItemListDrink;
        }
        else {
            tmepItemList = menuItemListDesert;
        }

        return tmepItemList;
    }
    public  int getListMaxSize(){
        return maxMenuListSize;
    }
}
