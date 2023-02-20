import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.io.*;
import java.security.IdentityScope;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.locks.Condition;

public class Locky implements Runnable{

    // Variables for thraeds
    private String name;
    private boolean ateCake;
    private boolean poundCake = true;
    private static Set<String> globalSet = new ConcurrentSkipListSet<>();

    private static ReentrantLock lock = new ReentrantLock(true);
    //private final Condition condition = lock.newCondition();
    //private static Condition condition = lock.newCondition();
    
    
    // Constructor
    public Locky(String name, boolean ateCake )
    {
      this.name = name;
      this.ateCake = ateCake;
      
    }
    // Runs findPrimes
    public void run()
    {
      //System.out.println("Running..." +threadNum);
      accessMaze(name);
      
    }

    private void accessMaze(String name)
    {
      while(true) 
      {
       // System.out.println("Currently " + s.size() + " has had a slice of pound cake");
        if(lock.tryLock() ) 
        {
            try 
            {
                // The lock has been acquired, so perform some operation on the shared resource
                // ...
                if(this.ateCake != true &&  globalSet.size() <= 8)
                {
                  System.out.println("" + name + " has acquired the holy lock");
                  if(consumedCake())
                  {
                    System.out.println("" + name + " consumed a slice of pound cake!");
                    this.ateCake = true;
                    globalSet.add(name);
                    
                    System.out.println("Currently " + globalSet.size() + " has had a slice of pound cake");
                  }
                  else
                  {
                    System.out.println("" + name + " has a tummy ache. They will get a slice next time :(");
                    
                    
                  }
                }
                else
                {
                  System.out.println("" + name + " has already had a slice of cake and are full :)");
                  break; // Exit the loop when done
                }
                
               
                
            } finally {
                // Release the lock when done
                System.out.println("" + name + " has unlocked the lock");
                lock.unlock();
            }
        } 
        else 
        {
            // The lock is already held by another thread, so wait for a bit before trying again
            try {
                Thread.sleep(10);
                //condition.await();
            } catch (InterruptedException e) {
                // Handle the exception
            }
        }
      } 
    }

    private boolean consumedCake()
    {
      if(this.poundCake == false)
      {
        this.poundCake = true;

      }

      Random random = new Random();
      int randomNumber = random.nextInt(100); // Generates a random integer between 0 and 99
      int threshold = 50; // The threshold value for the event

      if(randomNumber > threshold) 
      {
        // The random number is greater than the threshold, so perform the event
        this.poundCake = false;
        return true;
      }


      return false;
    }

    
    
  
    public static void main(String[] args) 
    {
      // Start Timer
      long start = System.currentTimeMillis();
      long end;
       
      System.out.println("Check primes.txt");

      // Create eight threads and start them.

      // Thread 1
      Locky m1 = new Locky("Eren Yeager", false);
      Thread my1 = new Thread(m1);
      
      // Thread 2
      Locky m2 = new Locky("Itachi Uchiha", false);
      Thread my2 = new Thread(m2);
      

      // Thread 3
      Locky m3 = new Locky("Gon Freecss", false);
      Thread my3 = new Thread(m3);

      // Thread 4
      Locky m4 = new Locky("Killua Zoldyck", false);
      Thread my4 = new Thread(m4);

      // Thread 5
      Locky m5 = new Locky("Miyamoto Musashi", false);
      Thread my5 = new Thread(m5);
      // Thread 6
      Locky m6 = new Locky("Thorfinn Karlsefni", false);
      Thread my6 = new Thread(m6);

      // Thread 7
      Locky m7 = new Locky("Ken Kaneki", false);
      Thread my7 = new Thread(m7);
      
      // Thread 8
      Locky m8 = new Locky("Yuji Itadori", false);
      Thread my8 = new Thread(m8);

      // Start all threads
      my1.start();
      my2.start();
      my3.start();
      my4.start();
      my5.start();
      my6.start();
      my7.start();
      my8.start();


      
      
      



      // After all threads finish run the rest of code, so we can time how long the program takes.
      try
      {
        my1.join();
        my2.join();
        my3.join();
        my4.join();
        my5.join();
        my6.join();
        my7.join();
        my8.join();
      }
      catch(Exception e)
      {
        System.out.println(e);
      }

     
      // Stop timer
      end = System.currentTimeMillis();
      
      // Create primes.txt and write neccessary info ot it.
      try
      {
        FileWriter w = new FileWriter("primes.txt");
        w.write("Execution Time: " + (end - start) + "ms\n");
        
        w.close();
      }
      catch(Exception e)
      {
        System.out.println(e);
      }

    }
  }