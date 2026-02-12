
package ExtraCurricularSmallProjects.ProducerConsumerProblem;

public class code{
    public static void main(String[] args) {
        Multithreading resource = new Multithreading();
        producer producer = new producer(resource);
        consumer consumer = new consumer(resource);

        producer.start();
        consumer.start();

    }
}

class Multithreading{
    private int data;
    private boolean available = false;

    public synchronized void produce(int value){
        while(available){
            try{ wait(); } catch(InterruptedException e){e.printStackTrace();}
        }

        data = value;
        available = true;
        System.out.println("produced " + value);
        notify();
    }

    public synchronized void consume(){
        while(!available){
            try{wait();}catch (InterruptedException e){e.printStackTrace();}
        }

        System.out.println("consumed " + data);
        available = false;
        notify();
    }
}

class producer extends Thread{
    private Multithreading resource;

    producer(Multithreading resource){
        this.resource = resource;
    }
    public void run(){
        for(int i=1; i<=5; i++){
            resource.produce(i);
            try{Thread.sleep(500);} catch(InterruptedException e){e.printStackTrace();}
        }
    }
}

class consumer extends Thread{
    private Multithreading resource;

    consumer(Multithreading resource){
        this.resource = resource;
    }

    public void run(){
        for(int i=1; i<=5; i++){
            resource.consume();
            try{Thread.sleep(500);} catch(InterruptedException e){e.printStackTrace();}
        }
    }
}
