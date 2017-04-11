public class BoundedBufferSimulation {
public static void main (String args[]) {
	Buffer buffer = new Buffer();
	// Create one producer and one consumer process
	int id1=100;
	int id2=200;
	Thread producer1 = new Thread(new Producer(buffer,id1++));
	Thread consumer1 = new Thread(new Consumer(buffer,id2++));
	producer1.start();
	consumer1.start();

}
}

