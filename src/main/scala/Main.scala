import java.net.NetworkInterface

object Main extends App {
  val nis = NetworkInterface.getNetworkInterfaces
  val ni = nis.nextElement()
  println("if " + ni.getName)
  println("hw " + ni.getHardwareAddress)
}
