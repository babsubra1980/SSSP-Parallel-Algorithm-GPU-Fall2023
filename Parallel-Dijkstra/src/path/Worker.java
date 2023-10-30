package path;
import java.util.concurrent.locks.Lock;
import static path.Application.n;
import static path.Application.infinity;

public class Worker implements Runnable
{

	private WorkPool workPool;
	private int weight[][];
	private int mindist[];
	private boolean inflag[];
	private Lock L[];
	
	public Worker(WorkPool p, int weight[][], int mindist[], boolean inflag[], Lock L[])
	{ 
		this.workPool = p;
		this.weight = weight;
		this.mindist = mindist;
		this.inflag = inflag;
		this.L = L; 
	}
	
	@Override
	public void run() 
	{
		int vertex = workPool.Getwork();
		int w;
		while(vertex != -1)
		{
			inflag[vertex] = false;
			for(w = 0; w < n; w++)
			{
				if(weight[vertex][w] < infinity)
				{
					int newDist = mindist[vertex] + weight[vertex][w];
					if(newDist >= mindist[w])
						continue;
					L[w].lock();
					if(newDist < mindist[w])
					{
						mindist[w] = newDist;
						L[w].unlock();
						if( ! inflag[w])
						{
							inflag[w] = true;
							workPool.Putwork(w);
						}
					}
					else
					{
						L[w].unlock();
					}//end of inner if
				}//end of outer if
			}//end of for
			vertex = workPool.Getwork();	
		}//end of while
        
	}/*End of Run() */

}