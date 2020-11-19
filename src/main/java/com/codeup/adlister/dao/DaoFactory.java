package com.codeup.adlister.dao;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static UserPictures getUserPicDao;
    private static AdPictures getGetAdsPicDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }

    public static UserPictures getGetUserPicDao() {
        if (getUserPicDao == null) {
            getUserPicDao = new MySQLusrPicDao(config);
        }
        return getUserPicDao;
    }

    public static AdPictures getGetAdsPicDao() {
        if (getGetAdsPicDao == null) {
            getGetAdsPicDao = new MySQLadPicDao(config);
        }
        return getGetAdsPicDao;
    }
}
