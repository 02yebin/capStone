package com.cookandroid.capstonedesign;

import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchRecommend {

    //음식 추천 알고리즘에 사용할 데이터 생성
    TodayVO todayVO= new TodayVO();
    RecipeVO recipeVO = new RecipeVO();
    //레시피가 담긴 리스트
    List<RecipeVO> recipeVOList = new ArrayList<>();
    Map<String,String> specialDate = new HashMap<>();
    //높거나 낮은 온도에 대한 추천레시피가 담긴 리스트
    List<String> highTempDate = new ArrayList<>();
    List<String> lowTempDate = new ArrayList<>();

    //음식 추천 알고리즘
    public String searchImg(String today) {

        for (String date : specialDate.keySet()) {
            //특정 날짜일때
            if(today.equals(date)) {
                //해당 날짜의 추천되는 레시피 반환
                return specialDate.get(date);
            }
        }
        //특정 날짜 아닌 경우 30도 이상일때
        if(todayVO.getTemperature() > 30) {
            //리스트 내에 레시피중 랜덤으로 반환하여 추천
            return highTempDate.get((int)(Math.random() * highTempDate.size()));
        }
        else if(todayVO.getTemperature() < 0) {
            //리스트 내에  레시피중 랜덤으로 반환하여 추천
            return lowTempDate.get((int)(Math.random() * lowTempDate.size()));
        }
        //그 외에 경우에 랜덤으로 레시피 추천
        else {
            return recipeVOList.get((int)(Math.random() * lowTempDate.size())).getRecipeName();
        }

    }

    /*
    public void setMainImg() {
       cookImg.setVisibility(View.VISIBLE);
    }
    */
}
