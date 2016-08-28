package info.songjie.learn.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
	private Object target;
	public MyInvocationHandler(Object target){
		this.target = target;
	}
	
	public Object getProxy(){
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String proxyClassName = proxy.getClass().getName();
		System.out.println("proxyClassName:" + proxyClassName);
		
		System.out.println("before method invoke");
		Object invokeResult = method.invoke(target, args);
		System.out.println("after method invoke");
		return invokeResult;
	}
}
