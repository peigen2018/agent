package com.pg.agent;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.text.MessageFormat;

public class LocalClassVistor extends ClassVisitor {
    public static Integer api = Opcodes.ASM9;


    protected LocalClassVistor(ClassVisitor classVisitor) {
        super(api, classVisitor);
    }


    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {


        MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
        if (mv != null && !"<init>".equals(name)) {
            System.out.println(MessageFormat.format("access:{0} name:{1} descriptor:{2} signature:{3} exceptions:{4}", access, name,

                    descriptor,signature,exceptions));

            return new LocalMethodVisitor(api,mv);
        }
        return mv;

    }
}
