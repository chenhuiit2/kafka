/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package kafka.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import kafka.utils.ShutdownableThread;

public class Consumer extends ShutdownableThread
{
  private final KafkaConsumer<Integer, String> consumer;
  private final String topic;
  private final String name;
  Random rd = new Random();
  
  public Consumer(String name,String topic)
  {
    super("KafkaConsumerExample", false);
    Properties props = new Properties();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaProperties.kafkaServerURL + ":" + KafkaProperties.kafkaServerPort);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, "gm");
    props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
    props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
    props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerDeserializer");
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");

    consumer = new KafkaConsumer<>(props);
    this.topic = topic;
    this.name = name;
    
    System.out.print("321321312");
  }

  @Override
  public void doWork() {
	 List<String> list = new ArrayList<String>();
	 list.add(topic);
    consumer.subscribe(list);
    ConsumerRecords<Integer, String> records = consumer.poll(1000);
    for (ConsumerRecord<Integer, String> record : records) {
    	
    		System.out.println("Received message: (" + record.key() + ", " + record.value() + ") at offset " + record.offset() + " from :" + record.topic() + ":name:" + name);
    }
  }

  @Override
  public String name() {
    return null;
  }

  @Override
  public boolean isInterruptible() {
    return false;
  }
}