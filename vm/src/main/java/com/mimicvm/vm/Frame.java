package com.mimicvm.vm;

import com.mimicvm.shared.method.VMethod;

public final class Frame {

    private final VMethod method;
    private final LocalVarArray locals;
    private final Stack stack;

    private int pc = 0;

    public Frame(VMethod method) {
        this.method = method;
        this.locals = new LocalVarArray(method.maxLocals());
        this.stack = new Stack(method.maxStack());
    }

    public VMethod getMethod() {
        return method;
    }

    public LocalVarArray getLocals() {
        return locals;
    }

    public Stack getStack() {
        return stack;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }
}
