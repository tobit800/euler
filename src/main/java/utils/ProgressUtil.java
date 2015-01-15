package utils;

import java.util.Timer;
import java.util.TimerTask;

public class ProgressUtil
{
	private static long starttime;
	private static final Timer timer = new Timer();
	private static final TimerTask PRINTOUT = new TimerTask()
	{
		int seconds = 1;

		@Override
		public void run()
		{
			System.out.print(".");
			if (seconds++ % 60 == 0)
			{
				System.out.println();
			}
		}
	};

	public static void start()
	{
		starttime = System.currentTimeMillis();
		timer.schedule(PRINTOUT, 1000, 1000);
	}

	public static void stop()
	{
		final long stoptime = System.currentTimeMillis();
		timer.cancel();
		System.out.println("Benötigte " + (stoptime - starttime) + " ms.");
	}
}
