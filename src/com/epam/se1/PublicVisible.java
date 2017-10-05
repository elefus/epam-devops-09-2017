package com.epam.se1;

public class PublicVisible {



    public int publicVisible;
    int packageVisible;
    protected int protectedVisible;
    private int privateVisible;


    private void method() {
        System.out.println(privateVisible);
    }

    public static void staticMethod() {

    }

}

class PackageVisible {

    public static void main(String[] args) {
        PublicVisible reference = new PublicVisible();
        System.out.println(reference.publicVisible);
        System.out.println(reference.packageVisible);
        System.out.println(reference.protectedVisible);
    }
}

class PackageVisible2 {
}


class PackageVisible3 {
}
