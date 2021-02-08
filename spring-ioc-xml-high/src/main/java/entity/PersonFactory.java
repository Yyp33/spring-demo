package entity;

public class PersonFactory {


    public Person createPerson(String name){
        Child child = new Child();
        child.setName("工厂对象中的工厂方法创建，非静态，传参"+name);
        return child;

    }

}
