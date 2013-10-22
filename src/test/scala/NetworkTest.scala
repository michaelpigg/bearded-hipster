import java.net.InetAddress
import java.net.NetworkInterface
import org.scalatest.matchers.MustMatchers
import org.scalatest.WordSpec
class NetworkTest extends WordSpec with MustMatchers {

  "getNetworkAddress" must {
    "work on single call" {
      val networkInterfacesEnum = NetworkInterface.getNetworkInterfaces
      val ni = networkInterfacesEnum.nextElement()
      println("if" + ni.getName)
      val ha = ni.getHardwareAddress
      println("hw" + ha)
    }
    "return MAC address" in {
      val networkInterfacesEnum = NetworkInterface.getNetworkInterfaces
      val networkInterfaces = scala.collection.JavaConverters.enumerationAsScalaIteratorConverter(networkInterfacesEnum).asScala
      val ha = networkInterfaces.find(ha => ha.getHardwareAddress != null && ha.getHardwareAddress.length == 6)
        .map(_.getHardwareAddress)
        .getOrElse(InetAddress.getLocalHost.getHostName.getBytes)
      ha must not be(null)
    }

    "iterate MAC address" in {
      val nis = NetworkInterface.getNetworkInterfaces
      while (nis.hasMoreElements) {
        val ni = nis.nextElement()
        println("if " + ni.getName)
        println("hw " + ni.getHardwareAddress)
      }
    }

    "maybe work from Java code" in {
      JavaNetworkInterface.iterateInterfaces()
    }
  }
}

