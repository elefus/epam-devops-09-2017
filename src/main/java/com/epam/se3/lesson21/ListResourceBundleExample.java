package com.epam.se3.lesson21;

import java.util.ListResourceBundle;

public class ListResourceBundleExample extends ListResourceBundle {

    @Override
    public Object[][] getContents() {
        return new Object[][] {
                { "prop.key1", "value01" },
                { "prop.key2", "value02" },
        };
    }
}

