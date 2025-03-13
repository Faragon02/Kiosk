package kiosk.level5part2.kiosk.menu;

import java.util.List;

public class Menu implements ItemList {
    private int categoryId;
    private String category;
    private List<Item> items;
    private int maxItemid;

    public Menu(int categoryId,String category, List<Item> itemList) {
        this.categoryId = categoryId;
        this.category = category;
        this.items = itemList;
    }

    /* 25. 03. 13
     * 카테고리 이름을 가져옵니다.
     * */
    @Override
    public String getCategoryName() {
        return category;
    }
    /* 25. 03. 13
     * 카테고리 Id를 가져옵니다.
     * */
    @Override
    public int getCategoryId() {
        return categoryId;
    }
    /* 25. 03. 13
     * 카테고리의 리스트 길이를 가져옵니다.
     * */
    @Override
    public int getListLength() {
        return items.size();
    }
    /* 25. 03. 13
     * 카테고리의 리스트 내용을 표시합옵니다.
     * */
    @Override
    public void getItemShowList() {
        System.out.println("[======="+ category + "선택=======]");
        for (Item item : items) {
            if (item.getName().equals("Back")) {
                System.out.println(item.getId() + "." + item.getName());
            } else {
                System.out.println(String.format("%d. %-15s | w %.1f| %s", item.getId(), item.getName(), (double)item.getPrice()/1000, item.getInfo()));
            }
        }
    }
    /* 25. 03. 13
     * 카테고리의 리스트에 입력한 값이 있다면
     * 있으면 객체를 반환
     * 없으면 null 반환
     * */
    @Override
    public Item getItem(int findNum) {
        for (Item item : items) {
            if (item.getId() == findNum) {
                return item;
            }
        }
        return null;
    }
}
