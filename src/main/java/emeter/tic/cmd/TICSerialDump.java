package emeter.tic.cmd;

/**
 * Utility class used to read and display raw TIC frame
 */
public class TICSerialDump
{
    /**
     * Utility version
     */
    public static final String VERSION = "1.0";
    /**
     * Utility entry point
     *
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println(TICSerialDump.class.getSimpleName() + " v" + TICSerialDump.VERSION);
    }
}
