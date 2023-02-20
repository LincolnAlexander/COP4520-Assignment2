import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.io.*;
import java.security.IdentityScope;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.locks.Condition;

public class Vase implements Runnable{

    // Variables for thraeds
    private String name;
    private boolean seenVase;
    private static String door = "AVAILABLE";
    private static Set<String> globalSet = new ConcurrentSkipListSet<>();

    private static ReentrantLock lock = new ReentrantLock(true);
    
    
    
    // Constructor
    public Vase(String name, boolean seenVase )
    {
      this.name = name;
      this.seenVase = seenVase;
      
    }
    // Runs findPrimes
    public void run()
    {
      
      accessMaze(name);
      
    }

    private void accessMaze(String name)
    {
      while(true && globalSet.size() <= 8) 
      {
       // System.out.println("Currently " + s.size() + " has had a slice of pound cake");
        if(lock.tryLock()) 
        {
            try 
            {
                // The lock has been acquired, so perform some operation on the shared resource
                // ...
                if(this.seenVase != true &&  globalSet.size() < 8 && isShowroomAvailable() )
                {
                  System.out.println("" + name + " has eneterd the showroom and has seen the glimmering crysal vase!");
                  door = "BUSY";
                  this.seenVase = true;
                  globalSet.add(name);
                    
                  System.out.println("Currently " + globalSet.size() + " has saw the vase");
        
                }
                else
                {
                  System.out.println("" + name + " has already entered the showroom and wants to explore the party :)");
                  break; // Exit the loop when done
                }
                
               
                
            } finally {
                // Release the lock when done
                door = "AVAILABLE";
                System.out.println("" + name + " has opened the door to others");
                lock.unlock();
            }
        } 
        else 
        {
            // The lock is already held by another thread, so wait for a bit before trying again
            try {
                Thread.sleep(0);
                //condition.await();
            } catch (InterruptedException e) {
                // Handle the exception
            }
        }
      } 
    }

    private boolean isShowroomAvailable()
    {
      if(door.equals("BUSY"))
      {
        System.out.println("Sorry there is a guest inside, please come back again");
        return false;

      }



      return true;
    }

    
    
  
    public static void main(String[] args) 
    {
      // Start Timer
      long start = System.currentTimeMillis();
      long end;
       
      System.out.println("Check primes.txt");

      // Create eight threads and start them.

      // Thread 1
      Vase m1 = new Vase("Eren Yeager", false);
      Thread my1 = new Thread(m1);
      
      // Thread 2
      Vase m2 = new Vase("Itachi Uchiha", false);
      Thread my2 = new Thread(m2);
      

      // Thread 3
      Vase m3 = new Vase("Gon Freecss", false);
      Thread my3 = new Thread(m3);

      // Thread 4
      Vase m4 = new Vase("Killua Zoldyck", false);
      Thread my4 = new Thread(m4);

      // Thread 5
      Vase m5 = new Vase("Miyamoto Musashi", false);
      Thread my5 = new Thread(m5);
      // Thread 6
      Vase m6 = new Vase("Thorfinn Karlsefni", false);
      Thread my6 = new Thread(m6);

      // Thread 7
      Vase m7 = new Vase("Ken Kaneki", false);
      Thread my7 = new Thread(m7);
      
      // Thread 8
      Vase m8 = new Vase("Yuji Itadori", false);
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