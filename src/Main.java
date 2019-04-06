import control.Control;

public class Main {

    /**
     * The main method, simply parses the args and runs the Control class with the benchpoints size
     *
     * @param args the benchpoints to use
     */
    public static void main(String[] args) {
        new Control(250_000L).manageTesting();
    }

}
