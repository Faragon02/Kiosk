package kiosk.Level5lv1.kiosk.workOder;

import jdk.jfr.Category;

import java.util.ArrayList;
import java.util.List;


public class Menu {
    //private  MenuItem menuItem;
    private List<String> categoryItemList;
    private List<MenuItem> menuItemListBuger;
    private List<MenuItem> menuItemListDrink;
    private List<MenuItem> menuItemListDesert;
    private List<MenuItem> shoppingCart;


    public Menu() {

        categoryItemList = new ArrayList<>();
        menuItemListBuger = new ArrayList<>();
        menuItemListDrink = new ArrayList<>();
        menuItemListDesert = new ArrayList<>();
        shoppingCart = new ArrayList<>();
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
    public  void  getItemList(int categoryNum){
        List<MenuItem> tmepItemList;

         if(categoryNum  ==1 )
         {
             tmepItemList = menuItemListBuger;
         }
         else if(categoryNum ==2)
         {
             tmepItemList = menuItemListDrink;
         }
         else {
             tmepItemList = menuItemListDesert;
         }

        for(MenuItem item :tmepItemList)
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
    public List<MenuItem>getItemListBuger(){
        return menuItemListBuger;
    }
    public List<MenuItem>getItemListDrink(){
       return menuItemListDrink;
    }
    public List<MenuItem> getItemListDesert(){
       return menuItemListDesert;
    }
}
