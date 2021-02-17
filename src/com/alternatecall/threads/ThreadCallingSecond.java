package com.alternatecall.threads;

import com.alternatecall.callingclass.Foo;

import java.util.concurrent.Phaser;

public class ThreadCallingSecond implements Runnable {

    private Foo foo;
    private String name;
    private Phaser phaser;

    public ThreadCallingSecond(Foo foo, Phaser phaser) {
        this.phaser = phaser;
        this.foo = foo;
        name = "Second";
        phaser.register();
    }

    @Override
    public void run() {
        phaser.arriveAndAwaitAdvance();
        foo.second();
        phaser.arriveAndDeregister();
    }
}
