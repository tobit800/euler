package javamag.arnohaase.proxies;

import static java.lang.System.out;
import static java.text.MessageFormat.format;
import static java.util.Arrays.asList;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LoggingInvokationHandler implements InvocationHandler {
	private final Object inner;

	public LoggingInvokationHandler(Object inner) {
		super();
		this.inner = inner;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		try {
			final Object result = method.invoke(inner, args);
			out.println(format("invoking {0}:{1}", method, args) == null ? ""
					: asList(args) + "->" + result);
			return result;
		} catch (final InvocationTargetException exc) {
			throw exc.getCause();
		}
	}

}
