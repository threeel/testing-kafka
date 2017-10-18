import java.util.Date

import org.apache.kafka.clients.producer.{ProducerRecord, RecordMetadata}

import scala.util.Random

object Main extends App {

  override def main(args: Array[String]): Unit = {

    println(Config.env("PATH"))
    val config = new Config("54.36.136.170:9092")
    val topic = "testing"
    val message = Message.create("testing", "Testing the Message in the Queue")
    val client = new PubSub[String, String](config)

    val rnd = new Random()
    val t = System.currentTimeMillis()
    for (nEvents <- Range(0, 1000)) {
      val runtime = new Date().getTime()
      val ip = "192.168.2." + rnd.nextInt(255)
      val msg = runtime + "," + nEvents + ",www.example.com," + ip
      val m = Message.create(ip, msg)
      val data = new ProducerRecord[String, String](topic, m.key, m.value)
      val response = client.publish(topic, m)
      println(response)
    }

  }
}
