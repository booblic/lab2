package lab2.bakery.oven;

import lab2.bakery.controller.Controller;
import lab2.bakery.event.Event;
import lab2.bakery.exception.NegativeProductsQuantityException;
import lab2.bakery.menu.Menu;
import lab2.bakery.products.Products;
import lab2.bakery.products.SingletonProducts;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OvenControls<T extends Products> extends Controller {

    private static final int size = 10;

    private static int quantity;

    public OvenControls(int quantity){
        OvenControls.quantity = quantity;
    }

    public static int getSize() {
        return size;
    }

    public class Bake extends Event {

        Class<T> productClass;

        public Bake(long delayTime, Class<T> productClass) {
            super(delayTime);
            this.productClass = productClass;
        }

        public void action() {
            try {
                Method method = productClass.getMethod("setQuantity", int.class);
                method.setAccessible(true);
                method.invoke(productClass.newInstance(), quantity);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        public String toString() {
            return "Испечено " + quantity + " буханок хлеба";
        }
    }

}
