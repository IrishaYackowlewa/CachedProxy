import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        InterCalculator calc = new Calculator();
        InterCalculator calcProxy = (InterCalculator) Proxy.newProxyInstance(
                InterCalculator.class.getClassLoader(),
                new Class<?>[] { InterCalculator.class },
                new ProxyCalculator(calc)
        );
	    System.out.println(calcProxy.square(5));
        System.out.println(calcProxy.square(3));
        System.out.println(calcProxy.sum(3.6,5));
        System.out.println(calcProxy.square(52401));
        System.out.println(calcProxy.square(25));
        System.out.println(calcProxy.square(1));
        System.out.println(calcProxy.square(52401));
        System.out.println(calcProxy.square(3));
        System.out.println(calcProxy.multip(3.63,5));
        System.out.println(calcProxy.square(52401));
    }
}
