package kiosk.level5part1.kiosk.workOder;

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
    public void setAddShoppingCart(MenuItem item){
        shoppingCart.add(item);

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
    public List<MenuItem>getItemListBuger(){
        return menuItemListBuger;
    }
    public List<MenuItem>getItemListDrink(){
       return menuItemListDrink;
    }
    public List<MenuItem> getItemListDesert(){
       return menuItemListDesert;
    }
    public void getAddShoppingCart(MenuItem item){
        //정상적으로 추가 되었을때.
        if(shoppingCart.contains(item) == true) {
            System.out.println(String.format("%s가 장바구니에 추가되었습니다. 금액은 %d", item.getName(), item.getPrice()));
        }
        else {
            System.out.println("추가되어 있지 않는 메뉴입니다.");
        }

    }
}
