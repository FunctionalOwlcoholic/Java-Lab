public class ThreadSync
{
   public static class SyncObject // this class will hold shared memory that multiple threads want to access
   {
      public final int numThreads; // we don't plan to change this variable, so multiple threads can read from it safely
      
      public int counter = 0; // this variable will be changed by several threads
                              // therefore we need to worry about 'race condition'
                              // in which several threads might try to change the variable while others are reading it
      
      SyncObject(int numThreads)
      {
         this.numThreads = numThreads;
      }
   }
   
   public static void main(String[] args)
   {
      SyncObject sync = new SyncObject(5); // create a single object that we can share with each of our threads
      
      Thread[] threads = new Thread[sync.numThreads]; // an array of Thread objects that we will call .start() on later
      
      for (int i = 0; i < sync.numThreads; i++)
      {
         final int threadIndex = i; // we cannot reference local variable i inside the anonymous object below
                                    // therefore we have to create a final or final-ish variable
                                    // object references like sync can be referenced without issues
         
         threads[i] = new Thread() // this is called an anonymous object, basically we call a constructor while also
         {                         // defining methods and variables inside that object
            
            @Override public void run() // the run() method is the start method for every thread
            {
               // operations that do not use shared memory go outside the synchronized block
               // do not assume that all methods like System.out.println() are thread safe
               
               synchronized (sync) // this synchronized block will prevent multiple threads from altering the shared memory
               {
                  System.out.println("I am thread " + threadIndex); // we cannot reference local variables like i
                                                                    // so we are using final variable threadIndex
                  
                  System.out.println("The count is now " + ++sync.counter); // sync.counter is shared memory
                                                                            // thus we cannot have multiple threads
                                                                            // try to increment at the same time
                  
                  if (sync.counter == sync.numThreads)
                  {
                     System.out.println("All threads will be notified");
                     
                     sync.notifyAll(); // this methods unblocks all threads that have called sync.wait()
                  }
                  else
                  {
                     System.out.println("Thread " + threadIndex + " will wait until notified");
                     
                     // the .wait() method halts the current thread until it is notified from the same object sync
                     try { sync.wait(); } catch (Exception e) { System.out.println("catched exception"); }
                     
                     System.out.println("Thread " + threadIndex + " has been notified");
                  }
               }
            }
         };
      }
      
      for (int i = 0; i < sync.numThreads; i++)
      {
         // you must call .start() on each Thread object for it to call its run() method
         // do not assume that each thread will execute run() in the order you call .start()
         threads[i].start();
      }
   }
}
