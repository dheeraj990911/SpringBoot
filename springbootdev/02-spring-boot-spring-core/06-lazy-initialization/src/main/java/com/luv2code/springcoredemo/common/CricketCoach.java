package com.luv2code.springcoredemo.common;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("In Constructor:"+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice FastBowling for 15 minutes..!!";
    }
}
