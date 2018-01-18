package com.sunzn.rock.library;

import java.util.Random;

/**
 * Created by sunzn on 2017/12/25.
 */

public class RackViewRandom {

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public static int randDot() {
        Random rand = new Random();
        return rand.nextBoolean() ? -1 : 1;
    }

}
