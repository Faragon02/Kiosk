package kiosk.level5part1.menu;

import java.util.List;

public interface ItemList {

     //get
      String getCategoryName();

      int getCategoryNum();

      int getListLength();

      void getShowList();

      List<Item> getItemList();

      Item itemCheck(int findNum);
}
