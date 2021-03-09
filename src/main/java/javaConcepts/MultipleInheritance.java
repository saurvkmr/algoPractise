package javaConcepts;

public class MultipleInheritance implements Test1, Test2{
    /*@Override
    public void name() {
        System.out.println("Inside class");
    }*/

    @Override
    public void print() {
        this.name();
    }

    public static void main(String[] args) {
        Test2 inheritance = new MultipleInheritance();
        inheritance.name();
        inheritance.print();
    }
}

interface Test1 {
    /*default void name() {
        System.out.println("name");
    }*/

    void print();
}

interface Test2 {
    default void name() {
        System.out.println("name2");
    }

    void print();
}
