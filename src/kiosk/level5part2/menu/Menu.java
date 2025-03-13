package kiosk.level5part2.menu;

import java.util.List;

public class Menu implements ItemList {
    private int categoryNum;
    private String category;
    private List<Item> Items;

    private int maxItemNumber;

    public Menu(int categoryNum, String category, List<Item> Items) {
        this.categoryNum = categoryNum;
        this.category = category;
        this.Items = Items;
    }

    @Override
    public int getCategoryNum() {
        return categoryNum;
    }

    @Override
    public String getCategoryName() {
        return category;
    }

    @Override
    public int getListLength() {
        return Items.size();
    }
    @Override
    public List<Item> getItemList() {
        return Items;
    }

    @Override
    public Item itemCheck(int findNum) {
        Item tempItem =null;

        for(Item item : Items)
        {
            if(item.getNumber() == findNum)
            {
                tempItem =item;
                break;
            }
        }
        return tempItem;
    }

    @Override
    public void getShowList() {
        maxItemNumber = 0;
        for(Item item :Items)
        {
            if( maxItemNumber< item.getNumber())
            {
                maxItemNumber= item.getNumber();
            }

            if(item.getName() == "Back")
            {
                System.out.println(item.getNumber() + "."  + item.getName());
            }
            else {
                System.out.println(String.format("%d. %s | w %.1f| %s", item.getNumber(),item.getName(), item.getPrice(), item.getInfo()));
            }

        }
    }

    public  int getMaxItemNum(){
        return  maxItemNumber;
    }
}
