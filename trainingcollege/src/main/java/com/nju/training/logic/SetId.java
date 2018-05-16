package com.nju.training.logic;

import java.text.NumberFormat;

public class SetId {
    public String setStudentId(int number){
        return "s"+setFormat(number+1);

    }

    public String setInstitutionId(int number){
        return "i"+setFormat(number+1);

    }

    public String setAccountId(int number){
        return "a"+setFormat(number+1);
    }
    public String setCourseId(int number){
        return "c"+setFormat(number+1);
    }

    public String setOrderId(int number){
        return "o"+setFormat(number+1);
    }
    public String setTeacherId(int number){
        return "t"+setFormat(number+1);
    }

    public String setFormat(int number){
        //得到一个NumberFormat的实例
        NumberFormat nf = NumberFormat.getInstance();
//设置是否使用分组
        nf.setGroupingUsed(false);
//设置最大整数位数
        nf.setMaximumIntegerDigits(6);
//设置最小整数位数
        nf.setMinimumIntegerDigits(6);
        return nf.format(number);

    }
}
