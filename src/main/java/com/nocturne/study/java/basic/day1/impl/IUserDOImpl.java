package com.nocturne.study.java.basic.day1.impl;

import com.nocturne.study.java.basic.day1.IUserDO;

/**
 * Created by liang.ding on 2019-04-24.
 */
public class IUserDOImpl implements IUserDO {
    @Override
    public void save() {
        System.out.println("从数据库查询用户");
    }
}
