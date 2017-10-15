
import java.util
import java.util.concurrent.Future

import org.apache.kafka.clients.producer.{Callback, KafkaProducer, ProducerRecord, RecordMetadata}
import org.apache.kafka.clients.consumer.{ConsumerRebalanceListener, ConsumerRecord, ConsumerRecords, KafkaConsumer}


class PubSub[K, V](config: Config) {

  private val producer = new KafkaProducer[K, V](config.getProperties())

  private val consumer = new KafkaConsumer[K, V](config.getProperties())


  def publish(topic: String, message: Message[K, V], callback: Callback = null): Future[RecordMetadata] = {

    val messageToSend = new ProducerRecord[K, V](topic, message.key, message.value)

    if (callback == null)
      producer.send(messageToSend, callback)
    else
      producer.send(messageToSend)
  }

  def subscribe(topics: util.Collection[String],listener: ConsumerRebalanceListener): Unit = {
    consumer.subscribe(topics)
  }

}
