package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo7 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<CompletableFuture<Double>> result = getUserDetailById(125)
                .thenApply(Demo7::getCreditRating);

        System.out.println(result.get().get());

        CompletableFuture<Double> result2 = getUserDetailById(125)
                .thenCompose(Demo7::getCreditRating);
        System.out.println(result2.get());
    }

    private static CompletableFuture<String> getUserDetailById(int userId) {
        return CompletableFuture.supplyAsync(() -> "user details string");
    }

    private static CompletableFuture<Double> getCreditRating(String userDetails) {
        return CompletableFuture.supplyAsync(() -> 110.98);
    }

}