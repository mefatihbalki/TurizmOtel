package entity;

public class Pension {
    private int id;
    private String pensionName;

    public Pension(int id, String pensionName) {
        this.id = id;
        this.pensionName = pensionName;
    }

    public int getId() {
        return id;
    }

    public String getPensionName() {
        return pensionName;
    }

    public void setPensionName(String pensionName) {
        this.pensionName = pensionName;
    }

    public String toString(){
        return this.pensionName;
    }
}
