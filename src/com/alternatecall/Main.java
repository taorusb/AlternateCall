package com.alternatecall;

import com.alternatecall.callingclass.Foo;
import com.alternatecall.threads.ThreadCallingFirst;
import com.alternatecall.threads.ThreadCallingSecond;
import com.alternatecall.threads.ThreadCallingThird;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        Foo foo = new Foo();
        Phaser phaser = new Phaser();
        ExecutorService service = Executors.newFixedThreadPool(3);

        service.execute(new ThreadCallingFirst(foo, phaser));
        service.execute(new ThreadCallingSecond(foo, phaser));
        service.execute(new ThreadCallingThird(foo, phaser));

        service.shutdown();
    }
}

