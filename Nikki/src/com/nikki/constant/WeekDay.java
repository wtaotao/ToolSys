package com.nikki.constant;

public enum WeekDay {
    MONDAY (1),
    TUESDAY (2),
    WEDNESDAY (3),
    THURSDAY (4),
    FRIDAY (5),
    SATAURDAY (6),
    SUNDAY (7);
    
    private int index;
    
    private WeekDay(int index) {
        this.index = index;
    }
    
    public int getIndex() {
        return index;
    }
}
