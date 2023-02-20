import java.util.*;
import java.io.*;

public class MyClass implements Runnable{

    // Variables for thraeds
    

    // Constructor
    public MyClass()
    {
      
    }
    // Runs findPrimes
    public void run()
    {
      //System.out.println("Running..." +threadNum);
      
    }

    // Implented Sieve of Eratosthenes
    
  
    public static void main(String[] args) 
    {
      // Start Timer
      long start = System.currentTimeMillis();
      long end;
       
      System.out.println("Check primes.txt");

      // Create eight threads and start them.

      // Thread 1
      MyClass m1 = new MyClass();
      Thread my1 = new Thread(m1);
      
      // Thread 2
      MyClass m2 = new MyClass();
      Thread my2 = new Thread(m2);
      

      // Thread 3
      MyClass m3 = new MyClass();
      Thread my3 = new Thread(m3);

      // Thread 4
      MyClass m4 = new MyClass();
      Thread my4 = new Thread(m4);

      // Thread 5
      MyClass m5 = new MyClass();
      Thread my5 = new Thread(m5);
      // Thread 6
      MyClass m6 = new MyClass();
      Thread my6 = new Thread(m6);

      // Thread 7
      MyClass m7 = new MyClass();
      Thread my7 = new Thread(m7);
      
      // Thread 8
      MyClass m8 = new MyClass();
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