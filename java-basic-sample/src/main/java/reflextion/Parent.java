package reflextion;

public class Parent {
    public String father = null;
    public String mother = null;

    public Parent() {}
    public Parent(String father, String mother) {
        this.father = father;
        this.mother = mother;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }
}
