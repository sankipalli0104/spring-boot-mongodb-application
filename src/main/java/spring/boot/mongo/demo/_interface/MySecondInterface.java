package spring.boot.mongo.demo._interface;

public interface MySecondInterface {
    default void mySecondInterface(){
        System.out.println("MySecondInterface::mySecondInterface()");
    };
    void mySecondInterface2();

    void common();
}
