package dataBase;

public class DataChildren {
    private int dniChildren;
    private String nameChildren;
    private String surnameChildren;
    private String birthday;
    private String dateIn;
    private String  sex;
    private String  regular;


    public DataChildren(int dniChildren, String nameChildren, String surnameChildren, String birthday, String dateIn, String sex, String regular) {
        this.dniChildren = dniChildren;
        this.nameChildren = nameChildren;
        this.surnameChildren = surnameChildren;
        this.birthday = birthday;
        this.dateIn = dateIn;
        this.sex = sex;
        this.regular = regular;
    }

    public DataChildren() {

    }

    public String  getBirthday() { return birthday; }

    public void setBirthday(String  birthday) { this.birthday = birthday; }

    public int getDniChildren() {
        return dniChildren;
    }

    public void setDniChildren(int dniChildren) {
        this.dniChildren = dniChildren;
    }

    public String getNameChildren() {
        return nameChildren;
    }

    public void setNameChildren(String nameChildren) {
        this.nameChildren = nameChildren;
    }

    public String getSurnameChildren() {
        return surnameChildren;
    }

    public void setSurnameChildren(String surnameChildren) {
        this.surnameChildren = surnameChildren;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }
}
