package com.alternatecall.threads;

import com.alternatecall.callingclass.Foo;

import java.util.concurrent.Phaser;

public class ThreadCallingThird implements Runnable {

    private Foo foo;
    private String name;
    private Phaser phaser;

    public ThreadCallingThird(Foo foo, Phaser phaser) {
        this.phaser = phaser;
        this.foo = foo;
        name = "Third";
        phaser.register();
    }

    @Override
    public void run() {
        phaser.arriveAndAwaitAdvance();
        phaser.arriveAndAwaitAdvance();
        foo.third();
        phaser.arriveAndDeregister();
    }
}
