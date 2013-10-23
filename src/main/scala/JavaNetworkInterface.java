import java.net.NetworkInterface;
import java.util.Enumeration;

public class JavaNetworkInterface {
    public static void main(String[] args) {
        iterateInterfaces();
    }

    public static void iterateInterfaces() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface ni = networkInterfaces.nextElement();
                System.out.println("if: " + ni.getName());
                System.out.println("hw: " + ni.getHardwareAddress());
            }
        } catch (Exception e) {
            throw new RuntimeException("exception: " + e.toString());
        }

    }
}
