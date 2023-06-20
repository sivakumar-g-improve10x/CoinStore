package com.example.coinstore.model;

import com.google.gson.annotations.SerializedName;

public class Coin {
    private String id;
    private String name;
    private String symbol;
    private Integer rank;
    @SerializedName("is_new")
    private String isNew;
    @SerializedName("isActive")
    private String isActive;
    private String type;

}