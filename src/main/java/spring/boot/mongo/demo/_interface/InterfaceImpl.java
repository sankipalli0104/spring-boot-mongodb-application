package spring.boot.mongo.demo._interface;

import java.io.Serializable;

public class InterfaceImpl implements MyFirstInterface, MySecondInterface, Serializable {
    @Override
    public void myFirstInterface2() {
        System.out.println("InterfaceImpl::myFirstInterface2()");
    }

    @Override
    public void common() {

    }

    @Override
    public void mySecondInterface2() {
        System.out.println("InterfaceImpl::mySecondInterface2()");
    }


}
