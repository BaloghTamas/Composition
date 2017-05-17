package hu.aut.example.composition.model;


public class Header implements Listable {
    private String name;

    public Header(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
