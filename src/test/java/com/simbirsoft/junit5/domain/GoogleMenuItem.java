package com.simbirsoft.junit5.domain;

public enum GoogleMenuItem {
    ALL("Все"),
    VIDEO("Видео"),
    NEWS("Новости"),
    PICTURES("Картинки"),
    MAPS("Карты"),
    MORE("Ещё");

    private String desc;

    GoogleMenuItem(String desc) {
        this.desc = desc;
    }
}
