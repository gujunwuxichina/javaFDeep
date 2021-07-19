package com.gujun.enumTest;

/**
 * @ClassName: Operation
 * @Author GuJun
 * @Description:
 * @Date 2021年07月19日 20:52
 */
public enum Operation {

    PLUS{
        @Override
        public double eval(double x, double y) {
            return x+y;
        }
    },
    MINUS{
        @Override
        public double eval(double x, double y) {
            return x-y;
        }
    },
    TIMES{
        @Override
        public double eval(double x, double y) {
            return x*y;
        }
    },
    DIVIDE{
        @Override
        public double eval(double x, double y) {
            return x/y;
        }
    };

    public abstract double eval(double x,double y);

}
