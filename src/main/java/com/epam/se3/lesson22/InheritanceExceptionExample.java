package com.epam.se3.lesson22;

import java.io.EOFException;
import java.io.IOException;

public class InheritanceExceptionExample {
}

class BaseCl {
    public BaseCl() throws IOException, ArithmeticException {
    }

    public static void methodA() throws IOException {
    }
}

class DerivativeCl extends BaseCl {
    public DerivativeCl() throws EOFException, IOException, ArithmeticException {
        super();
    }

    public static void methodA() throws EOFException {
    }
}

class DerivativeCl2 extends BaseCl {
    // ошибок компиляции нет
    public DerivativeCl2() throws Exception {
        super();
    }

    // compile error
//    public static void methodA() throws Exception {
//    }
}
