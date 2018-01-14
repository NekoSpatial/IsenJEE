package yncrea.pw01.model;

public class Pharmacist {

    private String login;
    private String password;

    public Pharmacist() {

    }

    public Pharmacist(String a, String b) {
        this.login = a;
        this.password = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pharmacist)) return false;

        Pharmacist that = (Pharmacist) o;

        if (!login.equals(that.login)) return false;
        return password.equals(that.password);
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
