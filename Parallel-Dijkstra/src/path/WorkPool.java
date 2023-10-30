package path;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static path.Application.numworkers;

public class WorkPool 
{
	static BlockingQueue<Integer> stream;
	private int count;
	private Lock m;

	public WorkPool()
	{
		stream = new LinkedBlockingQueue<Integer>();
		m = new ReentrantLock();
	}
	 
	/* field declarations here */
	public int Getwork( ) 
	{
		int workCount; 
		int vertex = 0;
		m.lock();
			workCount = count - 1;
			count = workCount;
		m.unlock();
		if(workCount == -numworkers)
		{	
				try
				{
					for(int i = 0; i < numworkers; i++)
					{
					   stream.put(-1);
					}
					
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				vertex = -1;
				
			
		}
		else
		{
			try
			{
				vertex = stream.take();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		return vertex;
	
	}
	
	public void Putwork(int item)
    {
		m.lock();
        count++;
        m.unlock();
        try 
        {
            stream.put(item);
            
        } catch (InterruptedException e) 
        {
            e.printStackTrace();
        }

	}
}