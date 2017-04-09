package com.example.joe.healthhacker.Service;
/**
 * Created by Joe on 4/8/17.
 */

public interface NutritionServiceCallBack {
        void serviceSuccess(String[] itemInfo);
        void serviceFailure(Exception exception);
}
