
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableClass {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Callable<Integer> callableTask = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000);
                return 42;
            }
        };

        Future<Integer> f1 = executor.submit(callableTask);

        try {
            if (f1.isDone()) {
                Integer result = f1.get();
                System.out.println("Result of Future Object: " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
