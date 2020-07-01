package com.yong.utils.utils;

/**
 * Create by Joe on 2019/11/12
 * ProjectName: Infusion
 * PackageName: com.wzh.study.net
 */
public class Constant {
    //权限
    //无存储权限
    public static final int NOT_READ_AND_WRITE = 1000;
    //有存储权限
    public static final int READ_AND_WRITE = 1001;
    //没有定位权限
    public static final int NOT_WAKE_LOCK = 2000;
    //有定位权限
    public static final int WAKE_LOCK = 2001;

//
    public static final String BASE_URL = "http://171.221.244.26:6969";
//    public static final String BASE_URL = "http://192.168.0.101:6999";
    public static final String TOKEN = "token";
    //登陆用户名
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    //是否是第二次或二次以上登陆
    public static final String IS_TWO = "isTwo";

    //是否记住密码
    public static final String REMEMBER_PASSWORD = "remember_password";
    //用户姓名
    public static final String NAME = "name";

    //车辆carCard
    public static final String CAR_CARD = "carCard";
    //车辆id
    public static final String CAR_Id = "carId";
    //人员id
    public static final String PERSONNEL_Id = "personnelId";

    //请求参数
    public static final String REQUEST_MAP = "requestMap";

    //maxImage最大图片数量
    public static final int MAX_IMAGE_COUNT = 10;

}
