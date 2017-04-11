public class Writer extends Thread {
	DataAccessPolicyManager2 lockManager;
	public Writer (DataAccessPolicyManager2 lockManager) {
			this.lockManager = lockManager;
		}
	public void run() {
		lockManager.acquireWriteLock();
		System.out.println("I am a writing acitivty");
		try {
    			Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
    		Thread.currentThread().interrupt();
		}		

		lockManager.releaseWriteLock();
	}
}

