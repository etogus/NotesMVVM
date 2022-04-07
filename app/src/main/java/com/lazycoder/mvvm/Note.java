package com.lazycoder.mvvm;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;

    //private String title;

    //private String description;

    //private int priority;

    private String name;
    private String company;
    private String screen;
    private String ram;
    private String price;

//    public Note(String title, String description, int priority) {
//        this.title = title;
//        this.description = description;
//        this.priority = priority;
//    }


    public Note(String name, String company, String screen, String ram, String price) {
        this.name = name;
        this.company = company;
        this.screen = screen;
        this.ram = ram;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getScreen() {
        return screen;
    }

    public String getRam() {
        return ram;
    }

    public String getPrice() {
        return price;
    }

    //    public String getTitle() {
//        return title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public int getPriority() {
//        return priority;
//    }
}