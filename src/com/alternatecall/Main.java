package com.alternatecall;

import com.alternatecall.callingclass.Foo;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        Foo foo = new Foo();
        ExecutorService service = Executors.newFixedThreadPool(3);

        service.execute(foo::first);
        service.execute(foo::second);
        service.execute(foo::third);

        service.shutdown();
    }
}

