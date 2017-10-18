import kafka.utils.Json

case class Message[K, V](key: K, value: V) {

}

object Message {

  def create(key: String, value: String): Message[String, String] = {
    new Message(key, value)
  }
}
