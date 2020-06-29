import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

public class ProxyCalculator implements InvocationHandler {
    private final Object original;
    private HashMap setCacheValue;

    public ProxyCalculator(Object original){
        this.original = original;
        setCacheValue = new HashMap();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Cache.class)){
            double arg = (double) args[0];
            if (!setCacheValue.containsKey(arg)) {
                setCacheValue.put(arg, (double) method.invoke(original, arg));
                System.out.println("Сработало");
            }
            return setCacheValue.get(arg);
        }
        else{
            System.out.println("Метод не кеширован");
            return method.invoke(original,args);
        }
    }
}
