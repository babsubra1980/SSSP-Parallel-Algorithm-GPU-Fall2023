package path;



import static path.WorkPool.stream;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;




public class Application 
{

	public static final int numworkers = Runtime.getRuntime().availableProcessors();
	public static final int n = 400;
	public static final int infinity = 32000;
	private static WorkPool workpool = new WorkPool();
	private static int weight[][] = new int[n][n];
	private static int mindist[] = new int[n];
	private static boolean inflag[] = new boolean[n];
	private static Lock L[] = new ReentrantLock[n];

	
	public static void main(String[] args)
	{
	
		long par_time;
		long seq_time;
		Application app = new Application();
		/*initialization*/
//	   int weight_c[][] = {
//		    {infinity, 4, 8, infinity, infinity},
//			{infinity, infinity, 3, 1, infinity},
//			{infinity, infinity, infinity, infinity, 5},
//			{infinity, infinity, 2, infinity, 10},
//			{infinity, infinity, infinity, infinity, infinity}
//			};
		System.out.println("Number of cores: " + numworkers);
		/*-------Sequential-------*/
	    System.out.println("\n------Sequential Part-------\n ");
	   
	    performanceInit();
		initSequential();
		long  seq_start =System.currentTimeMillis();
		
		app.runSequential(weight);
		
		long  seq_end = System.currentTimeMillis();
		seq_time = (seq_end - seq_start); 
		System.out.print("Sequential Elapsed Time: ");
		System.out.println((double) seq_time + " milliseconds. \n"); 
        app.print();
        
		/*-------Parallel--------*/
        System.out.println("\n------Parallel Part-------\n ");
		LinkedList<Thread> threads = new LinkedList<Thread>();
		app.initParallel(); 
		long par_start = System.nanoTime();
		
        for (int i = 0; i < numworkers; i++) 
        {
            Worker worker = new Worker(workpool, weight, mindist, inflag, L);
            Thread thread = new Thread(worker);
            threads.add(thread);
            thread.start();
        }

      //Joining threads to the "main" thread
        for (int i = 0; i < numworkers; i++) 
        {
            try 
            {
                threads.pop().join();
                
            } catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }

        long par_end = System.nanoTime();
        par_time = (par_end - par_start);
		System.out.print("Parallel Elapsed Time: ");
		System.out.println(par_time + " milliseconds.");
		System.out.println("Speed up is : " + (double)seq_time / par_time);
		System.out.println("Utilization : " + ((double)seq_time / par_time ) / numworkers );
		app.print();
	}
	
	
	public static void performanceInit()
	{
		int point[][] = new int[n][2];
		int i,j, temp=0, dist=0;
		Random rand = new Random(500);
		for ( i = 0; i < n; i++ ) {
		temp = rand.nextInt(1000); point[i][0] = temp;
		temp = rand.nextInt(1000); point[i][1] = temp;
		}
		for ( i = 0; i < n; i++ )
		{
		  for ( j = 0; j <= i; j++ )
		  {
			  if ( i == j)
		      {
				  weight[i][j] = infinity;
		      }
		      else 
		      {
					temp = point[i][0]-point[j][0];
					dist = temp*temp;
					temp = point[i][1]-point[j][1];
					dist = dist + temp*temp;
					weight[i][j] = dist; weight[j][i] = dist;
		      }
		  }  
		}//end of outer for
	}//End of method
	
    static void initSequential() 
    {
        for (int i = 0; i < mindist.length; i++) 
        {
            mindist[i] = infinity;
            inflag[i] = false;
        }
        mindist[0] = 0;
        stream.add(0);
        inflag[0] = true;
    }
    
    void initParallel() 
    {
        for (int i = 0; i < mindist.length; i++) 
        {
            mindist[i] = infinity;
            inflag[i] = false;
        }
        mindist[0] = 0;
        workpool.Putwork(0);
        inflag[0] = true;
        //Init locks
        for (int i = 0; i < n; i++)
        {
            L[i] = new ReentrantLock();
        }
    }

    
    void runSequential(int[][] weight) 
	{
        while (!stream.isEmpty()) 
        {
        	int newDistance;
            int vertex = stream.remove();
            inflag[vertex] = false;
            for (int i = 0; i < n; i++) 
            {
                if (weight[vertex][i] < infinity) 
                {
                    newDistance = mindist[vertex] + weight[vertex][i];
                    if (newDistance < mindist[i])
                    {
                        mindist[i] = newDistance;
                        if (!inflag[i])
                        {
                            inflag[i] = true;
                            stream.add(i);
                        }
                    }
                }   
            }
        }   
	
	}
    
    void print() {
//        if (n <= 100) 
//        {
            for (int i = 0; i < mindist.length; i++) 
            {
                System.out.println("Minimum path to " + i + " is " + mindist[i]);
            }
//        }
    }
    
 


}