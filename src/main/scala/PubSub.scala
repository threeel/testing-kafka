
import java.util
import java.util.Date
import java.util.concurrent.Future

import org.apache.kafka.clients.producer.{Callback, KafkaProducer, ProducerRecord, RecordMetadata}
import org.apache.kafka.clients.consumer.{ConsumerRebalanceListener, ConsumerRecord, ConsumerRecords, KafkaConsumer}

import scala.util.Random
//import org.apache.logging.log4j.scala.Logging
//import org.apache.logging.log4j.Level

class PubSub[K, V](config: Config) extends AutoCloseable {

  private val producer = new KafkaProducer[K, V](config.getProperties())


  def publish(topic: String, message: Message[K, V], callback: Callback = null): Future[RecordMetadata] = {


      //async
      //producer.send(data, (m,e) => {})
      //sync
//      producer.send(data)

      val messageToSend = new ProducerRecord[K, V](topic, message.key, message.value)

      if (callback == null)
        producer.send(messageToSend, callback)
      else {
        producer.send(messageToSend)
      }


    }

    def subscribe(topics: util.Collection[String], listener: ConsumerRebalanceListener): Unit = {

    }

    override def close(): Unit

    = producer.close()


  }
