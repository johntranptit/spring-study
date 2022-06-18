package com.example.springbootdocker.aop.ex1;

import org.springframework.aop.framework.ProxyFactory;

public class BeforeAdviceMain {
    public static void main(String[] args) {
        Robot robot = new Robot();
        BeforeSingAdvice singAdvice = new BeforeSingAdvice();

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(singAdvice);
        pf.setTarget(robot);
        Robot proxyRobot = (Robot) pf.getProxy();

        robot.sing();
        proxyRobot.sing();
    }
}
