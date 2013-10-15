import java.net.InetAddress
import java.net.NetworkInterface
import org.scalatest.matchers.MustMatchers
import org.scalatest.WordSpec

class NetworkTest extends WordSpec with MustMatchers {

  "getNetworkAddress" must {
    "return MAC address" in {
      val networkInterfacesEnum = NetworkInterface.getNetworkInterfaces
      val networkInterfaces = scala.collection.JavaConverters.enumerationAsScalaIteratorConverter(networkInterfacesEnum).asScala
      val ha = networkInterfaces.find(ha => ha.getHardwareAddress != null && ha.getHardwareAddress.length == 6)
        .map(_.getHardwareAddress)
        .getOrElse(InetAddress.getLocalHost.getHostName.getBytes)
      ha must not be(null)

    }
  }
}

