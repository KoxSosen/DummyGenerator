package com.github.koxsosen.Generator;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public class PropertiesGenerator {

    public String getRandomReason(int length) {
        EasyRandomParameters parameters = new EasyRandomParameters()
                .stringLengthRange(1, length);
        EasyRandom easyRandom = new EasyRandom(parameters);

        return easyRandom.toString();
    }

}
