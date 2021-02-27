package com.alternatecall.callingclass;

import java.util.concurrent.Phaser;

public class Foo {

    private final Phaser phaser;

    public Foo() {
        phaser = new Phaser(3);
    }

    public void first() {
        System.out.print("first");
        phaser.arriveAndAwaitAdvance();
        phaser.arriveAndDeregister();
    }

    public void second() {
        while (phaser.getPhase() < 1) {
            phaser.arriveAndAwaitAdvance();
        }
        System.out.print("second");
        phaser.arriveAndDeregister();
    }

    public void third() {
        while (phaser.getPhase() < 2) {
            phaser.arriveAndAwaitAdvance();
        }
        System.out.print("third");
    }
}
