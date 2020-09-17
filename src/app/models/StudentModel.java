package app.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class StudentModel {
    public static Integer counter = 1;
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleIntegerProperty age;

    public StudentModel(String name, Integer age) {
        this.id = new SimpleIntegerProperty(counter++);
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleIntegerProperty(age);
    }

    public Integer getId() {
        return this.id.get();
    }

    public String getName() {
        return this.name.get();
    }

    public Integer getAge() {
        return this.age.get();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
