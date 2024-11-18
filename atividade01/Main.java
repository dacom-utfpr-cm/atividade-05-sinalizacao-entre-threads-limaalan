package atividade01;
    public class Main {
        public static void main(String[] args) {
            System.out.println("// Testando com tempos iguais para produção e consumo ");
            ResourceMonitor resourceMonitor = new  ResourceMonitor();
            int consumerMaxSleepTime = 2000;
            int producerMaxSleepTime = 2000;
            Thread consumer = new Thread(new ConsumerThread(resourceMonitor,consumerMaxSleepTime),"Thread consumidora");
            Thread producer = new Thread(new ProducerThread(resourceMonitor,producerMaxSleepTime),"Thread produtora");

            consumer.start();
            producer.start();
            try {
                consumer.join();
                producer.join();
            } catch (InterruptedException e) {
            }


            System.out.println("// Produção muito mais rápida que o consumo ");
            resourceMonitor = new  ResourceMonitor();
            consumerMaxSleepTime = 2000;
            producerMaxSleepTime = 100;
            consumer = new Thread(new ConsumerThread(resourceMonitor,consumerMaxSleepTime),"Thread consumidora");
            producer = new Thread(new ProducerThread(resourceMonitor,producerMaxSleepTime),"Thread produtora");

            consumer.start();
            producer.start();
            try {
                consumer.join();
                producer.join();
            } catch (InterruptedException e) {
            }

            System.out.println("// Consumo muito mais rápido que a produção ");
            resourceMonitor = new  ResourceMonitor();
            consumerMaxSleepTime = 100;
            producerMaxSleepTime = 2000;
            consumer = new Thread(new ConsumerThread(resourceMonitor,consumerMaxSleepTime),"Thread consumidora");
            producer = new Thread(new ProducerThread(resourceMonitor,producerMaxSleepTime),"Thread produtora");

            consumer.start();
            producer.start();
            try {
                consumer.join();
                producer.join();
            } catch (InterruptedException e) {
            }

        }

    }
