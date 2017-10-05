package com.epam.se3;

import com.epam.se1.PublicVisible;

public class InheritedPublicVisibleClass extends PublicVisible {

    public void method() {
        System.out.println(publicVisible);
        System.out.println(protectedVisible);
//        System.out.println(packageVisible);
//        System.out.println(privateVisible);
    }
}
