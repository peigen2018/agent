package com.pg.agent;


import java.lang.instrument.Instrumentation;

public class PreMain {
    public static void premain(String args, Instrumentation inst) {

        System.out.println("start agent");

        inst.addTransformer(new ClassFindAll());
    }

    public static void premain(String agentArgs) {
        System.out.println("------------ agentArgs:" + agentArgs);
    }
}
