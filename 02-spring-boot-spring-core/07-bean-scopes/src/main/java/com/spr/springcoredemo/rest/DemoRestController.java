package com.spr.springcoredemo.rest;

import com.spr.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    private Coach mAnotherCoach;

    @Autowired
    @Qualifier("cricketCoach")
    private Coach mCricketCoach;

    private final Coach mTennisCoach;
    private Coach mBaseballCoach;

    @Autowired
    DemoRestController(
            @Qualifier("tennisCoach") Coach coach,
            @Qualifier("tennisCoach") Coach anotherCoach
    ) {
        System.out.println("In constructor " + getClass().getSimpleName());
        mTennisCoach = coach;
        mAnotherCoach = anotherCoach;
    }

//    @Autowired
//    public void setCoach(@Qualifier("baseballCoach") Coach coach) {
//        mBaseballCoach = coach;
//    }

    @GetMapping("/cricket")
    public String getCricketWorkout() {
        return mCricketCoach.getDailyWorkout();
    }

    @GetMapping("/baseball")
    public String getBaseballWorkout() {
        return mBaseballCoach.getDailyWorkout();
    }

    @GetMapping("/tennis")
    public String getTennisWorkout() {
        return mTennisCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing Bean instances mTennisCoach == mAnotherCoach : "
                + (mTennisCoach == mAnotherCoach);
    }

}
