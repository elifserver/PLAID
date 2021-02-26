package com.framework.pages.welcomePage;

import com.framework.base.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.List;

public class WelcomePage extends Base {

    public static boolean isWarningVisible() {
        return noFilterSelectedWarning.size()  > 0 ? true : false;
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.TextView")
    protected static MobileElement appName;

    @AndroidBy(id="io.plaidapp:id/" + "%s")
    protected static By menuIcons;

    @AndroidFindBy(id = "io.plaidapp:id/menu_search")
    protected static MobileElement searchIcon;


    @AndroidFindBy(id = "io.plaidapp:id/menu_theme")
    protected static MobileElement menuThemeIcon;

    @AndroidFindBy(id = "io.plaidapp:id/menu_filter")
    protected static MobileElement filterIcon;

    @AndroidFindBy(accessibility = "More options")
    protected static MobileElement moreOptionsIcon;


    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'About')]")
    protected static MobileElement optionSubMenuItem_About;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Log in')]")
    protected static MobileElement optionSubMenuItem_DesignerNewsLogin;


    @AndroidFindBy(xpath = "//*[contains(@text, 'Popular Designer News')]")
    protected static MobileElement filterSubMenuItem_PopularDesignerNews;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Material Design')]")
    protected static MobileElement filterSubMenuItem_MaterialDesign;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Product Hunt')]")
    protected static MobileElement filterSubMenuItem_ProductHunt;


    @AndroidFindBy(id = "io.plaidapp:id/no_filters")
    protected static List<MobileElement> noFilterSelectedWarning;

    @AndroidFindBy(id = "android:id/alertTitle")
    protected static List<MobileElement> errorFrame;

    @AndroidFindBy(xpath = "//android.widget.button[contains(text(),'App info')]")
    protected static MobileElement errorFrameAppInfoButton;

    @AndroidFindBy(id = "android:id/aerr_close")
    protected static MobileElement errorFrameCloseButton;






}
