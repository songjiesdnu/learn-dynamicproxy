package info.songjie.learn.dynamicproxy;

public class Client {
	public static void main(String[] args) {
		BookFacade bookFacade = new BookFacadeImpl();
		MyInvocationHandler handler = new MyInvocationHandler(bookFacade);
		BookFacade bookFacadeProxy = (BookFacade)handler.getProxy();
		bookFacadeProxy.addBook();
	}
}
