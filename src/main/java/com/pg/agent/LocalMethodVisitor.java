package com.pg.agent;


import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class LocalMethodVisitor extends MethodVisitor {

    public LocalMethodVisitor(int api, MethodVisitor methodVisitor) {
        super(api,methodVisitor);

    }




    @Override
    public void visitCode() {
        System.out.println();
        super.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        super.visitLdcInsn("Method Enter...");
        super.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        super.visitCode();
    }

}
