import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class IcnGeneration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //ExecutorService service = Executors.newFixedThreadPool(10);
		ExecutorService executor = Executors.newWorkStealingPool();
		List<Callable<Integer>> callables = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
		callables.add(() -> {
			int randomValue = 100000000 + ThreadLocalRandom.current().nextInt(900000000);
			System.out.println(randomValue);
			return randomValue;
		});
		}
		try {
			executor.invokeAll(callables);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
}
