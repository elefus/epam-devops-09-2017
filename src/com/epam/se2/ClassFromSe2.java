package com.epam.se2;

import com.epam.se1.AboutJava;
import com.epam.se1.PublicVisible;
//import com.epam.se1.PackageVisible;

public class ClassFromSe2 {

    public static void main(String[] args) {
        AboutJava about = new AboutJava();
        about.printReleaseData();

        com.epam.se3.AboutJava another = new com.epam.se3.AboutJava();

//        PackageVisible packageVisible = new PackageVisible();
        PublicVisible a;
    }
}
