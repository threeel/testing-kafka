
object Main extends App {

  override def main(args: Array[String]): Unit = {

    println(Config.env("PATH"))
    val config = new Config("54.36.136.170:9092")
    val topic = "testing"
    val message = Message.create("testing", "Testing the Message in the Queue")
    val client = new PubSub[String, String](config)

    val response = client.publish(topic, message)

    println(response)

  }
}
