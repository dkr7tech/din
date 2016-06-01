package com.web.utils;

import java.util.ArrayList;
import java.util.List;
/*http://thinkinginsoftware.blogspot.in/2011/06/jsp-jstl-to-render-tree-menu.html*/
public class MenuItem {
    private String key;
    private String url;
    private List<MenuItem> menuItems;
    private boolean selected;
     
    public MenuItem(String key, String url, List<MenuItem> menuItems, boolean selected) {
        super();
        this.key = key;
        this.url = url;
        this.menuItems = menuItems;
        this.selected = selected;
    }
     
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }  
    public void addMenuItem(MenuItem menuItem){
        if(menuItems == null){
            menuItems = new ArrayList<MenuItem>();
        }
        menuItems.add(menuItem);
    }
    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}