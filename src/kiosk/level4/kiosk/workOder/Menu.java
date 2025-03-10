package kiosk.level4.kiosk.workOder;
import kiosk.level4.kiosk.workOder.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Menu {
    //private  MenuItem menuItem;
    private List<String> categoryItemList;
    private List<MenuItem> menuItemListBuger;
    private List<MenuItem> menuItemListDrink;
    private List<MenuItem> menuItemListDesert;


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
    public void getItemListBuger(){
        for(MenuItem item :menuItemListBuger)
        {
            if(item.getName() == "Back")
            {
                System.out.println(item.getNumber() + "."  + item.getName());
            }
            else {
                System.out.println(String.format("%d. %s |%.1f| %s", item.getNumber(), item.getName(), (double)item.getPrice() / 1000, item.getInfo()));
            }

        }
    }
    public void getItemListDrink(){
        for(MenuItem item :menuItemListDrink)
        {
            if(item.getName() == "Back")
            {
                System.out.println(item.getNumber() + "."  + item.getName());
            }
            else {
                System.out.println(String.format("%d. %s |%.1f| %s", item.getNumber(), item.getName(), (double)item.getPrice() / 1000, item.getInfo()));
            }


        }
    }
    public void getItemListDesert(){
        for(MenuItem item :menuItemListDesert)
        {
            if(item.getName() == "Back")
            {
                System.out.println(item.getNumber() + "."  + item.getName());
            }
            else {
            System.out.println(String.format("%d. %s |%.1f| %s", item.getNumber(),item.getName(), (double)item.getPrice() /1000, item.getInfo()));
            }

        }
    }
}
