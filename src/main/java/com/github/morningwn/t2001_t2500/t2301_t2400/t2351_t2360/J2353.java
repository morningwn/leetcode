package com.github.morningwn.t2001_t2500.t2301_t2400.t2351_t2360;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/design-a-food-rating-system">2353. 设计食物评分系统</a>
 *
 * @author morningwn
 * @create in 2025/2/28 16:40
 */
public class J2353 {
    class FoodRatings {
        private Map<String, Food> data;
        private Map<String, Food> cuisinesRating;
        private Map<String, List<Food>> cuisinesFood;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            data = new HashMap<>();
            cuisinesRating = new HashMap<>();
            cuisinesFood = new HashMap<>();

            int n = foods.length;
            for (int i = 0; i < n; i++) {
                Food food = new Food(foods[i], cuisines[i], ratings[i]);
                data.put(foods[i], food);
            }

            // 初始化排序
            for (Map.Entry<String, Food> entry : data.entrySet()) {
                Food food = entry.getValue();
                // 方便后续排序
                List<Food> orDefault = cuisinesFood.computeIfAbsent(food.cuisine, k -> new ArrayList<>());
                orDefault.add(food);

                Food t = cuisinesRating.get(food.cuisine);

                if (t == null) {
                    cuisinesRating.put(food.cuisine, food);
                } else {
                    // 判断获取更大的
                    cuisinesRating.put(t.cuisine, maxFood(food, t));
                }
            }
        }

        public void changeRating(String food, int newRating) {
            Food f = data.get(food);
            f.rating = newRating;

            // 重新排序
            Food t = cuisinesRating.get(f.cuisine);
            if (t == f) {
                //两者相同，重新便利排序
                List<Food> foods = cuisinesFood.get(f.cuisine);
                Food max = t;
                for (Food tmp : foods) {
                    max = maxFood(max, tmp);
                }
                cuisinesRating.put(max.cuisine, max);
            } else {
                Food max = maxFood(f, t);
                cuisinesRating.put(max.cuisine, max);
            }

        }

        public String highestRated(String cuisine) {
            Food food = cuisinesRating.get(cuisine);
            return food.name;
        }

        private Food maxFood(Food f1, Food f2) {
            if (f1.rating > f2.rating) {
                return f1;
            } else if (f1.rating < f2.rating) {
                return f2;
            } else {
                if (f1.name.compareTo(f2.name) > 0) {
                    return f2;
                } else {
                    return f1;
                }
            }
        }

        private class Food {
            String name;
            String cuisine;
            int rating;

            public Food(String name, String cuisine, int rating) {
                this.name = name;
                this.cuisine = cuisine;
                this.rating = rating;
            }
        }
    }

}