package kiosk.level5part2;

import kiosk.level5part2.kiosk.Kiosk;
import kiosk.level5part2.kiosk.menu.Item;
import kiosk.level5part2.kiosk.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Item> burgers = new ArrayList<>();
        burgers.add(new Item(1, "ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.add(new Item(2, "SmokeShak", 8900,  "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.add(new Item(3, "CheeseBuger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.add(new Item(4, "HamBuger", 5400,  "비프패티를 기반으로 야채가 들어간 기본버거"));
        burgers.add(new Item(0, "Back"));

        List<Item> drinks = new ArrayList<>();
        drinks.add(new Item(1, "Cola", 1500, "콜라"));
        drinks.add(new Item(2, "ZeroCola", 1700,  "젤로 콜라"));
        drinks.add(new Item(3, "Cider", 1500, "사이다"));
        drinks.add(new Item(4, "ZeroCider", 1700,  "제로 사이다."));
        drinks.add(new Item(0, "Back"));

        List<Item> deserts = new ArrayList<>();
        deserts.add(new Item(1, "French frise", 1500, "감자 튀김"));
        deserts.add(new Item(2, "IceCream", 1700,  "소프트 아이스크림"));
        deserts.add(new Item(0, "Back"));

        List<Menu> menus = List.of(
                new Menu(1, "햄버거", burgers),
                new Menu(2,"음료수", drinks),
                new Menu(3,"디저트", deserts),
                new Menu(0,"종료", null)
        );
        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();

    }
}
