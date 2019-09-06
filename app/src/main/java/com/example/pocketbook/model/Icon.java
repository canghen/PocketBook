package com.example.pocketbook.model;

public class Icon {

    private String iconName;
    private int iconImage;

    public Icon(String iconName, int iconImage) {
        this.iconName = iconName;
        this.iconImage = iconImage;
    }

    public String getIconName() {
        return iconName;
    }

    public int getIconImage() {
        return iconImage;
    }
}
