package kiosk.level5part2.kiosk.menu;

public interface ItemList {

     //get
      String getCategoryName();

      int getCategoryId();

      int getListLength();

      void getItemShowList();


      Item getItem(int findNum);

}
