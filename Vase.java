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
    

    
    
    
    
    // Constructor
    public Vase(String name, boolean seenVase )
    {
      this.name = name;
      this.seenVase = seenVase;
      
    }
    // Runs findPrimes
    public void run()
    {
      
      //accessMaze(name);
      acessShowroom();
      
    }
    
    
    public void acessShowroom() {
        // Wait until the room is available
        while (!isShowroomAvailable()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Set the availability to BUSY since someone is inside
        
        door = "BUSY";
        this.seenVase = true;
        
        System.out.println("" + name + " has eneterd the showroom and has seen the glimmering crysal vase!");
        
        // Set the avavilabity of showroom back 
        
        door = "AVAILABLE";
    }
    
    
    // Checks if showroom is availabe and returns true/false
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
      
      
      System.out.println("The program finished in " +  (end - start) + "ms\n");

    }
  }