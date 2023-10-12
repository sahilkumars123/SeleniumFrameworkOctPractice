package com.qa.constants;

import java.util.Arrays;
import java.util.List;

public class AppConstants {

    public final static String LOGIN_PAGE_TITLE="Account Login";
    public final static String LOGIN_PAGE_URL_FRACTION="route=account/login";

     public final static String ACCOUNT_PAGE_TITLE="My Account";

    public static final List<String> EXPECTED_ACC_PAGE_HEADERS_LIST = Arrays.asList("My Account", "My Orders",
            "My Affiliate Account", "Newsletter");

    // public final static List<String> ACCOUNT_PAGE_HEADERS = {"My Account", "My Affiliate Account", "My Orders", "Newsletter"};

    public static final String USER_REGISTER_SUCCESS_MESSG = "Your Account Has Been Created!";


    //********* timeouts ************///////////


     public final static int SHORT_TIMEOUT = 5;
     public final static int MEDIUM_TIMEOUT = 10;
     public final static int LONG_TIMEOUT = 15;




}
