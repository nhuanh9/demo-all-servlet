package model;

public class Student {
    private int id;
    private String name;
    private Class clazz;
    private int age;

    public Student(int id, String name, Class clazz, int age) {
        this.id = id;
        this.name = name;
        this.clazz = clazz;
        this.age = age;
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
