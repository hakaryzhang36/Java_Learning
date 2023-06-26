package accessibility;

import accessibility.pa.TurtleInPa;

public class TurtleInAccess extends TurtleInPa {
    public void print() {
        System.out.println("----- Extended Class Access Super (in different package) -----");
        System.out.println(super.publicName);
        System.out.println(super.protectedName);
        System.out.println("Can't access super default.");
        System.out.println("Can't access super private.");
        System.out.println("---------------------------------------------------------");
    }
}
