package com.example.pocketbook.model;

public class ExpendIcon {

    private String iconName;
    private int imageId;

    public ExpendIcon(String iconName, int imageId) {
        this.iconName = iconName;
        this.imageId = imageId;
    }

    public String getIconName() {
        return iconName;
    }

    public int getImageId() {
        return imageId;
    }
}
