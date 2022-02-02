// Using an ExecutorService to execute Runnables.
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class NonParallelSieveTaskExecutor {
   public static void main(String[] args) {
      // create and name each runnable
      //final int primeArraySize = 147483647;
      final int primeArraySize = 147483647;//737418145
      //ArrayList<Boolean> thePrimes = new ArrayList<>(147483647*30);
      
      final long primeArrayListSize = 147483647*30;
      ArrayList<Boolean> thePrimes = new ArrayList<Boolean>();
      
      //boolean[] thePrimes = new boolean[primeArraySize];
        
      System.out.println("Starting Executor");
        
      System.out.println("Starting Executor");

      // create ExecutorService to manage threads
      //ExecutorService executorService = Executors.newCachedThreadPool();

      //Arrays.fill(thePrimes, true);
      
      long sTime = System.nanoTime();
      
      
      int j = 0;
      for(int i=0;i<primeArraySize;i++){
          thePrimes.add(true);
      }
      for (int i =2; i < primeArraySize; i++)
        if (thePrimes.get(i)) {
            //try {
            for (j = i+i; j < primeArraySize; j +=i)
                thePrimes.set(j,false);
            //}
            //catch (ArrayIndexOutOfBoundsException e) {
            //    System.out.println("caught error where i = " +i+" j equals "+j);
            //}
        }
      
      long eTime = System.nanoTime();
      System.out.println("started at " + sTime + " ended at "+eTime + " difference = " + (eTime - sTime));
      //executorService.shutdown();
      for (int k = primeArraySize -1; k >=0; k--)
        if (thePrimes.get(k)) {
            System.out.println("Max prime found as " + k);
            k = -1;
        }

      System.out.printf("Tasks started, main ends.%n%n");
   } 
} 


/**************************************************************************
 * (C) Copyright 1992-2015 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/