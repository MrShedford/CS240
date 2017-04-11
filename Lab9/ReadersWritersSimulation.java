public class ReadersWritersSimulation {
	public static void main (String args[]) {
		DataAccessPolicyManager2 lockManager = new DataAccessPolicyManager2();
		Reader reader1 = new Reader(lockManager);
		Reader reader2 = new Reader(lockManager);
		Reader reader3 = new Reader(lockManager);
		Writer writer = new Writer(lockManager);
	
		reader1.start();
		reader2.start();
		reader3.start();
		writer.start();
	}
}
