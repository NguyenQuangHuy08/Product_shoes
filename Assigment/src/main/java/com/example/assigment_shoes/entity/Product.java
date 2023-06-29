package com.example.assigment_shoes.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Product implements Serializable {

      private static final long serialVersionUID = 1L;

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer id;

      @NotBlank(message = "Please enter your's name")
      private String name;
      private Double price;
      private String image;
      @NotBlank(message = "Please enter your's title")
      private String title;
      private Integer soLuong;

      @ManyToOne
      @JoinColumn(name = "category_id")
      private Category category;

      @OneToMany(mappedBy = "product")
      private List<Users> users = new ArrayList<>();



    public Product() {
    }

    public Product(Integer id, @NotBlank(message = "Please enter your's name") String name, Double price, String image, @NotBlank(message = "Please enter your's title") String title, Integer soLuong, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.title = title;
        this.soLuong = soLuong;
        this.category = category;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
