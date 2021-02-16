package com.yyp.spring.dynmic.impl;

import com.yyp.spring.dynmic.Calculator;

public class CalculatorImpl implements Calculator {

    @Override
    public int add(int i, int j) {
        return i+j;
    }

    @Override
    public int multi(int i, int j) {
        return i*j;
    }
}
