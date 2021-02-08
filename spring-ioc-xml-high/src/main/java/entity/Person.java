package entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Person implements InitializingBean, DisposableBean {

    private Integer id;
    private String name;
    private String gender;
    private Date birthday;
    private List<String> hobbies;
    private Map<Integer, String> course;
    private Wife wife;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("setName");
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map<Integer, String> getCourse() {
        return course;
    }

    public void setCourse(Map<Integer, String> course) {
        this.course = course;
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", hobbies=" + hobbies +
                ", course=" + course +
                ", wife=" + wife +
                '}';
    }

    public Person() {
        System.out.println("加载persion");
    }

    public static Person createPerson(String name){
        Child child = new Child();
        if("1".equals(name)){
            child.setName("静态工厂创建1");
        }else{
            child.setName("静态工厂创建2");
        }
        return child;

    }

    public Person(Wife wife) {
        this.wife = wife;
        System.out.println("constructor自动注入");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化bean-实现接口方式");
    }

    public void destroy() throws Exception {
        System.out.println("销毁bean-实现接口方式");
    }

    public void initXml(){
        System.out.println("初始化bean-xml配置方式");
    }

    public void destroyXml(){
        System.out.println("销毁bean-xml配置方式");
    }
}
