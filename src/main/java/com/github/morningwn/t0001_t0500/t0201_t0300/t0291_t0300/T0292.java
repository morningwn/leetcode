package com.github.morningwn.t0001_t0500.t0201_t0300.t0291_t0300;


import com.github.morningwn.prefab.Out;
import org.junit.Test;

public class T0292 {

    @Test
    public void test() {
        Out.println(canWinNim(5));
    }

    public boolean canWinNim(int n) {

        return (n % 4 != 0);
    }

}
