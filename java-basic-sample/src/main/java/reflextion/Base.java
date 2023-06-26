package reflextion;

public class Base extends Parent{
    public String name = null;
    public static Integer count = 1;

    public Base(){}
    public Base(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
