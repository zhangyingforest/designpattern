package com.yc.designpattern.DMA5_建造者模式.DM2_complex;

public class MealBuilder {

   //构建对象中的属性，
   public Meal prepareVegMeal (){
      Meal meal = new Meal();
      meal.addItem(new VegBurger());
      meal.addItem(new Coke());


      return meal;
   }

   //构建对象中的属性，
   public Meal prepareNonVegMeal (){
      Meal meal = new Meal();
      meal.addItem(new ChickenBurger());
      meal.addItem(new Pepsi());
      return meal;
   }
}