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

public class KafkaConsumerProducerDemo implements KafkaProperties
{
  public static void main(String[] args)
  {
    final boolean isAsync = args.length > 0 ? !args[0].trim().toLowerCase().equals("sync") : true;
    Producer producerThread = new Producer(KafkaProperties.topic, isAsync);
    producerThread.start();
    
    //Producer producerThread2 = new Producer(KafkaProperties.topic2, isAsync);
    //producerThread2.start();    
//
    Consumer consumerThread = new Consumer("g1",KafkaProperties.topic);
    consumerThread.start();
    
    Consumer consumerThread2 = new Consumer("g2",KafkaProperties.topic);
    consumerThread2.start();   
    
  }
}
