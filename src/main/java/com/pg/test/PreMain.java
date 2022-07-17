package com.pg.test;


import java.lang.instrument.Instrumentation;

public class PreMain {
    public static void premain(String args, Instrumentation inst) {

        System.out.println("hello world");
    }

    public static void premain(String agentArgs) {
        System.out.println("------ premain方法，有一个入参 ------ agentArgs:" + agentArgs);
    }
}
