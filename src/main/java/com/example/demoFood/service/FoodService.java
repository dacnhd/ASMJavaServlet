package com.example.demoFood.service;

import com.example.demoFood.entity.Food;
import com.example.demoFood.repository.GenericRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class FoodService {
    private GenericRepository<Food> foodRepository; // model
    private String pattern = "yyyy-MM-dd";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    public FoodService() {
        this.foodRepository = new GenericRepository<>(Food.class);
    }

    public boolean create(Food obj) {
        obj.setCreateDate(simpleDateFormat.format(Calendar.getInstance().getTime()));
        obj.setCreateUpdate(simpleDateFormat.format(Calendar.getInstance().getTime()));
        return foodRepository.save(obj);
    }

    public List<Food> getList(){
        return foodRepository.findAll();
    }

    public Food getById(int id){
        return foodRepository.findById(id);
    }

    public boolean edit(int id, Food obj){
        obj.setCreateUpdate(simpleDateFormat.format(Calendar.getInstance().getTime()));
        return foodRepository.update(id, obj);
    }

    public boolean delete(int id){
        foodRepository.findById(id).setStatus(-1);
        foodRepository.findById(id).setCreateUpdate(simpleDateFormat.format(Calendar.getInstance().getTime()));
        return false;
    }
}
