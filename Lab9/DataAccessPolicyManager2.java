public class DataAccessPolicyManager2
{
  private int readCount, writeCount;
  private Semaphore mutexReadCount, mutexWriteCount;
  private Semaphore wrt, rdr;
	
	public DataAccessPolicyManager2 () {
	      readCount = 0;
	      writeCount = 0;
	      mutexReadCount = new Semaphore(1);
	      mutexWriteCount = new Semaphore(1);
	      wrt = new Semaphore(1); // to block writers
	      rdr = new Semaphore (1);  // to block readers
   } 
	public void acquireReadLock() {
		rdr.acquire();  // Contention for this method
		mutexReadCount.acquire();
		readCount = readCount + 1;
		if (readCount == 1) wrt.acquire(); // block writers 
		   mutexReadCount.release();
		rdr.release();  // allow another in   
   	 
   }	
	public void releaseReadLock() {
	   mutexReadCount.acquire();
	   readCount = readCount - 1;
	   if (readCount == 0) wrt.release(); //last reader	      
	   	mutexReadCount.release();
   }

	public void acquireWriteLock() {
	   mutexWriteCount.acquire();
	   writeCount = writeCount+1;
	   if (writeCount == 1) rdr.acquire(); //Block new readers 
	   	mutexWriteCount.release();
	   wrt.acquire();  // wait for existing readers/writer
	   }
	public void releaseWriteLock() {
	   wrt.release();
	   mutexWriteCount.acquire();
	   writeCount = writeCount - 1;
	   if (writeCount==0) rdr.release(); //no more writers      
	   	mutexWriteCount.release();   
	   }


}
