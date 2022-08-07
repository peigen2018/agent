package com.pg.agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import static org.objectweb.asm.ClassWriter.COMPUTE_FRAMES;
import static org.objectweb.asm.ClassWriter.COMPUTE_MAXS;


public class ClassFindAll implements ClassFileTransformer {
    public static final int COMPUTE_MAXS = 1;
    public static final int COMPUTE_FRAMES = 2;
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {


        if (StringUtils.isNotEmpty(className)){
            ClassReader cr = new ClassReader(classfileBuffer);
            ClassWriter classWriter = new ClassWriter(cr, COMPUTE_FRAMES | COMPUTE_MAXS);
            ClassVisitor cv = new LocalClassVistor(classWriter);
            cr.accept(cv, ClassReader.EXPAND_FRAMES);
            System.out.println("--------classname: " + className +"----------");

            return classWriter.toByteArray();
        }



        return null;
    }
}
