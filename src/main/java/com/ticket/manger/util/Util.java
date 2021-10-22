package com.ticket.manger.util;

import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Component
public class Util {
    public String getUniqueCode(){
        UUID uuid = UUID.randomUUID(); //unique
        return uuid.toString() + new Date().getTime(); //unique
    }

    public Date addDays (int day){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,day);
        return calendar.getTime();
    }

}
