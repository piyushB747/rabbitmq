package net.kanth.dto;

public class PayloadCreation {

    private String name;
    private String id;

    public PayloadCreation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PayloadCreation{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
