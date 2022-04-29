package com.qirsam.http.locale;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleRunner {

    public static void main(String[] args) {
        Locale locale = new Locale("ru", "RU");
        System.out.println(Locale.getDefault());

        var translations = ResourceBundle.getBundle("translations", Locale.US);
        System.out.println(translations.getString("page.login.password"));
    }
}


