package com.codeup.adlister.dao;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;

    private static Admins adminsDao;
    private static AdPictures adPicturesDao;
    private static Banners bannerDao;
    private static BusinessEmails businessEmailsDao;
    private static Businesses businessesDao;
    private static BusinessPictures businessPicturesDao;
    private static BusinessProfiles businessProfilesDao;
    private static Categories categoriesDao;
    private static SecurityQuestions securityQuestionsDao;
    private static SecurityAnswers securityAnswersDao;
    private static UserEmails userEmailsDao;
    private static UserPictures userPicturesDao;
    private static UserProfiles userProfilesDao;

    private static UserPictures getUserPicDao;

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


    public static Admins getAdminsDao() {
        if (adminsDao == null) {
            adminsDao = new MySQLAdminsDao(config);
        }
        return adminsDao;
    }

    public static AdPictures getAdPicturesDao() {
        if (adPicturesDao == null) {
            adPicturesDao = new MySQLAdPicturesDao(config);
        }
        return adPicturesDao;
    }

    public static Banners getBannerDao() {
        if (bannerDao == null) {
            bannerDao = new MySQLBannersDao(config);
        }
        return bannerDao;
    }

    public static BusinessEmails getBusinessEmailsDao() {
        if (businessEmailsDao == null) {
            businessEmailsDao = new MySQLBusinessEmailsDao(config);
        }
        return businessEmailsDao;
    }

    public static Businesses getBusinessesDao() {
        if (businessesDao == null) {
            businessesDao = new MySQLBusinessesDao(config);
        }
        return businessesDao;
    }

    public static BusinessPictures getBusinessPicturesDao() {
        if (businessPicturesDao == null) {
            businessPicturesDao = new MySQLBusinessPicDao(config);
        }
        return businessPicturesDao;
    }

    public static BusinessProfiles getBusinessProfilesDao() {
        if (businessProfilesDao == null) {
            businessProfilesDao = new MySQLBusinessProfilesDao(config);
        }
        return businessProfilesDao;
    }

    public static Categories getCategoriesDao() {
        if (categoriesDao == null) {
            categoriesDao = new MySQLCategoriesDao(config);
        }
        return categoriesDao;
    }

    public static SecurityQuestions getSecurityQuestionsDao() {
        if (securityQuestionsDao == null) {
            securityQuestionsDao = new MySQLSecurityQuestionsDao(config);
        }
        return securityQuestionsDao;
    }

    public static SecurityAnswers getSecurityAnswersDao() {
        if (securityAnswersDao == null) {
            securityAnswersDao = new MySQLSecurityAnswersDao(config);
        }
        return securityAnswersDao;
    }
    public static UserEmails getUserEmailsDao() {
        if (userEmailsDao == null) {
            userEmailsDao = new MySQLUserEmailsDao(config);
        }
        return userEmailsDao;
    }

    public static UserPictures getUserPicturesDao() {
        if (userPicturesDao == null) {
            userPicturesDao = new MySQLusrPicDao(config);
        }
        return userPicturesDao;
    }

    public static UserProfiles getUserProfilesDao() {
        if (userProfilesDao == null) {
            userProfilesDao = new MySQLUserProfilesDao(config);
        }
        return userProfilesDao;
    }

    public static UserPictures getGetUserPicDao() {
        if (getUserPicDao == null) {
            getUserPicDao = new MySQLusrPicDao(config);
        }
        return getUserPicDao;

    }

}
