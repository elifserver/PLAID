package com.framework.pages.welcomePage;

public class WelcomePageBody extends WelcomePage{
    public static boolean isWarningVisible() {
        return noFilterSelectedWarning.size()  > 0 ? true : false;
    }
}
