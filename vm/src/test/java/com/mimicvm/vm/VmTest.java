package com.mimicvm.vm;

import com.mimicvm.shared.method.VMethod;
import com.mimicvm.shared.method.VModule;
import com.mimicvm.shared.op.Opcodes;
import com.mimicvm.shared.type.Value;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VmTest implements Opcodes {

    @Test
    void test1() {

        final byte[] insns = {
                (byte) I32_CONST, 0x0, 0x0, 0x0, 0x2, // 2
                (byte) I32_CONST, 0x0, 0x0, 0x0, 0x0B, // 11
                (byte) I32_ADD,
                (byte) RETURN};


        final VModule module = new VModule(new VMethod[]{
                new VMethod(0, 2, 0, insns)
        });

        final Value result = new Interpreter(module, 0).run();

        assertEquals(Value.i32(13), result);
    }
}
