package accessibility.pa;

public class TurtleInPaExtended extends TurtleInPa {

    public void print() {
        System.out.println("----- Extended Class Access Super (in same package) -----");
        System.out.println(publicName);
        System.out.println(protectedName);
        System.out.println(defaultName);
        System.out.println("Can't access super private.");
        System.out.println("---------------------------------------------------------");
    }

}
