package kabutz;

import java.util.Observable;

public final class MyObserverEncapsulated
{
	private void update(Observable o, Object arg)
	{
		System.out.println("MyObserver.update");
		System.out.println("o = [" + o + "], arg = [" + arg + "]");
	}

	public void register(Observable observable)
	{
		observable.addObserver(this::update);
	}
}
