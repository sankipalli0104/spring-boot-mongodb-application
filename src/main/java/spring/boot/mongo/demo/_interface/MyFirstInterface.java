package spring.boot.mongo.demo._interface;

public interface MyFirstInterface {
    default void myFirstInterface(){
        System.out.println("MyFirstInterface::myFirstInterface()");
    };
    void myFirstInterface2();
    void common();
}
