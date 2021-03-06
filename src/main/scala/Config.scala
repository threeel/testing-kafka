import java.util.Properties
import scala.collection.JavaConversions._

case class Config(brokers: String, keySerializer: String = "org.apache.kafka.common.serialization.StringSerializer", valueSerializer: String = "org.apache.kafka.common.serialization.StringSerializer", clientId: String = "Que") {

  private val props = new Properties()

  props.put("bootstrap.servers", brokers)

  props.put("client.id", clientId)

  props.put("key.serializer", keySerializer)

  props.put("key.deserializer", keySerializer)

  props.put("value.serializer", valueSerializer)

  props.put("value.deserializer", valueSerializer)

  def getProperties(): Properties = {
    props
  }
}

object Config {


  def env(key: String, default: String = null): String = {
    val envVars = System.getenv()
    envVars.get(key)
  }

}
