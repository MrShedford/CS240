// All threads which use the data set being synchronised should 
// share the same DataAccessPolicyManager object to 
// coordinate access. The instance could be passed in to the 
// constructor for the Reader class.


public class Reader extends Thread {
	DataAccessPolicyManager2 lockManager;
	public Reader (DataAccessPolicyManager2 lockManager) {
		this.lockManager = lockManager;
	}

	public void run() {
		lockManager.acquireReadLock();
		//Do reading activity
		System.out.println("I am a reading acitivty");
		try {
    			Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
    		Thread.currentThread().interrupt();
		}
		lockManager.releaseReadLock();
	}
}

