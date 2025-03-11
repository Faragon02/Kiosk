package kiosk.level5part1;

import kiosk.level5part1.kiosk.workOder.Kiosk;
import kiosk.level5part1.kiosk.workOder.Menu;
import kiosk.level5part1.kiosk.workOder.MenuItem;

public class Main {
    public static void setCategory(Menu menu){
        String[] item = {
                "Burgers",
                "Drinks",
                "Desserts",
                "종료"
        };
        menu.setCategoryItemList(item);
    }

    public static void setMenuList(Menu menu) {
        menu.setmenuItemListBugerList(new MenuItem(1, "ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menu.setmenuItemListBugerList(new MenuItem(2, "SmokeShak", 8900,  "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menu.setmenuItemListBugerList(new MenuItem(3, "CheeseBuger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menu.setmenuItemListBugerList(new MenuItem(4, "HamBuger", 5400,  "비프패티를 기반으로 야채가 들어간 기본버거"));
        menu.setmenuItemListBugerList(new MenuItem(0, "Back", 0, ""));

        menu.setmenuItemListDrinkList(new MenuItem(1, "Cola", 1500, "콜라"));
        menu.setmenuItemListDrinkList(new MenuItem(2, "ZeroCola", 1700,  "젤로 콜라"));
        menu.setmenuItemListDrinkList(new MenuItem(3, "Cider", 1500, "사이다"));
        menu.setmenuItemListDrinkList(new MenuItem(4, "ZeroCider", 1700,  "제로 사이다."));
        menu.setmenuItemListDrinkList(new MenuItem(0, "Back", 0, ""));

        menu.setMenuItemListDesertList(new MenuItem(1, "French frise", 1500, "감자 튀김"));
        menu.setMenuItemListDesertList(new MenuItem(2, "IceCream", 1700,  "소프트 아이스크림"));
        menu.setMenuItemListDesertList(new MenuItem(0, "Back", 0, ""));
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        setCategory(menu);
        setMenuList(menu);

        Kiosk kiosk = new Kiosk();
        kiosk.Start(menu);
    }
}
