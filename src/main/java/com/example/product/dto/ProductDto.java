package com.example.product.dto;

public class ProductDto {
    private String id;
    private String name;
    private String type;
    private String category;
    private String description;

    public ProductDto() {

    }

    public ProductDto(String name, String type, String category, String description) {
        this(null, name, type, category, description);
    }

    public ProductDto(String id, String name, String type, String category, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.category = category;
        this.description = description;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


