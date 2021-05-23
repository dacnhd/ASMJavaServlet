package com.example.demoFood.entity;

import com.example.demoFood.hannotation.Column;
import com.example.demoFood.hannotation.Entity;
import com.example.demoFood.hannotation.Id;
import com.example.demoFood.helper.ValidateConstant;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Entity(tableName = "food")
public class Food {

    @Id(autoIncreament = true)
    @Column(columnName = "id", columnType = "int")
    private int id;
    @Column(columnName = "name", columnType = "varchar(255)")
    private String name;
    @Column(columnName = "category", columnType = "int")
    private int category; // 1: Món nướng, 2: Món luộc, 3: Món chay, 4: Đồ uống
    @Column(columnName = "descripts", columnType = "varchar(255)")
    private String descripts;
    @Column(columnName = "avatar", columnType = "varchar(255)")
    private String avatar;
    @Column(columnName = "price", columnType = "double")
    private double price;
    @Column(columnName = "createDate", columnType = "varchar(255)")
    private String createDate;
    @Column(columnName = "createUpdate", columnType = "varchar(255)")
    private String createUpdate;
    @Column(columnName = "status", columnType = "int")
    private int status; // 1:đang bán, 0:dừng bán, -1:đã xóa

    public Food() {
        name = "";
        category = 1;
        descripts = "";
        avatar = "";
        price = 0;
        status = -1;
    }

    public Food(String name, int category, String descripts, String avatar, double price, int status) {
        this.name = name == null ? "" : name;
        this.category = category;
        this.descripts = descripts == null ? "" : descripts;
        this.avatar = avatar == null ? "" : avatar;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getDescripts() {
        return descripts;
    }

    public void setDescripts(String descripts) {
        this.descripts = descripts;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateUpdate() {
        return createUpdate;
    }

    public void setCreateUpdate(String createUpdate) {
        this.createUpdate = createUpdate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private HashMap<String, ArrayList<String>> errors = new HashMap<>();

    public boolean isValid() {
        checkName();
        checkPrice();
        return errors.size() == 0;
    }

    private boolean checkPrice() {
        ArrayList<String> priceError = new ArrayList<>();
        if (this.price <= 0){
            priceError.add(ValidateConstant.FOOD_PRICE_REQUIRED_MESSAGE);
            errors.put(ValidateConstant.FOOD_PRICE_FIELDNAME, priceError);
        }
        return priceError.size() == 0;
    }

    private boolean checkName() {
        ArrayList<String> nameError = new ArrayList<>();
        if (this.name == null){
            nameError.add(ValidateConstant.FOOD_NAME_REQUIRED_MESSAGE);
            errors.put(ValidateConstant.FOOD_NAME_FIELDNAME, nameError);
        }
        if (this.name.length() < 8){
            nameError.add(ValidateConstant.FOOD_NAME_CHECKLENGTH_MESSAGE);
            errors.put(ValidateConstant.FOOD_NAME_FIELDNAME, nameError);
        }
        return nameError.size() == 0;
    }

    public HashMap<String, ArrayList<String>> getErrors() {
        return errors;
    }
}
