package javamag.arnohaase.proxies;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		new Demo().doIt();
	}

	@SuppressWarnings("unchecked")
	private void doIt() {
		final List<String> inner = new ArrayList<>();
		final List<String> l = (List<String>) Proxy.newProxyInstance(Thread
				.currentThread().getContextClassLoader(),
				new Class<?>[] { List.class }, new LoggingInvokationHandler(
						inner));

		l.add("a");
	}

}
