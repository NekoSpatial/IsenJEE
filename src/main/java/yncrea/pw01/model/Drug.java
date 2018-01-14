package yncrea.pw01.model;

public class Drug {

    private String name;

    private String lab;

    public String getName() {
        return name;
    }

    public Drug()
    {

    }

    public Drug(String name, String lab) {
        this.name = name;
        this.lab = lab;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }
}
