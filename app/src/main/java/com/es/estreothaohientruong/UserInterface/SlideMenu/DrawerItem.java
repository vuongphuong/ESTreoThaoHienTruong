package com.es.estreothaohientruong.UserInterface.SlideMenu;

import android.graphics.drawable.Drawable;

/**
 * Created by phuon on 7/4/2016.
 */
public class DrawerItem {
    String ItemName;
    Drawable imgResID;

    public DrawerItem(String itemName, Drawable imgResID) {
        super();
        ItemName = itemName;
        this.imgResID = imgResID;
    }

    public String getItemName() {
        return ItemName;
    }
    public void setItemName(String itemName) {
        ItemName = itemName;
    }
    public Drawable getImgResID() {
        return imgResID;
    }
    public void setImgResID(Drawable imgResID) {
        this.imgResID = imgResID;
    }

}
