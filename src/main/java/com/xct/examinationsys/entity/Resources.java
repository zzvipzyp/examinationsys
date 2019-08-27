package com.xct.examinationsys.entity;

import lombok.Data;

@Data
public class Resources {
    private int id;
    private String name;
    private Double price;
    private Integer number;
    private String description;
    private Integer state;
    private Integer kind;
}
