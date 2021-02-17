package com.alternatecall.threads;

import com.alternatecall.callingclass.Foo;

import java.util.concurrent.Phaser;

public class ThreadCallingFirst implements Runnable {

    private Foo foo;
    private String name;
    private Phaser phaser;

    public ThreadCallingFirst(Foo foo, Phaser phaser) {
        this.phaser = phaser;
        this.foo = foo;
        name = "First";
        phaser.register();
    }

    @Override
    public void run() {
        foo.first();
        phaser.arriveAndDeregister();
    }
}
