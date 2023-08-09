import java.util.concurrent.*
import java.util.concurrent.CompletableFuture
import java.util.function.Supplier // 추가해줘야 하는 부분

class Solution {

    companion object {
        val executor: ExecutorService = Executors.newFixedThreadPool(16)
    }

    fun solution(x: Int, y: Int, n: Int): Int {
        val future: CompletableFuture<Int> = CompletableFuture.supplyAsync(Supplier {
            calculateMinOperations(x, y, n)
        }, executor)

        val result: Int
        try {
            result = future.get() // Wait for the asynchronous task to complete
        } finally {
            executor.shutdown()
        }

        return result
    }

    private fun calculateMinOperations(x: Int, y: Int, n: Int): Int {
        val dp = IntArray(y + 1) { Integer.MAX_VALUE }

        dp[x] = 0

        for (i in x..y) {
            if (dp[i] == Integer.MAX_VALUE) continue

            if (i + n <= y) dp[i + n] = minOf(dp[i + n], dp[i] + 1)
            if (i * 2 <= y) dp[i * 2] = minOf(dp[i * 2], dp[i] + 1)
            if (i * 3 <= y) dp[i * 3] = minOf(dp[i * 3], dp[i] + 1)
        }

        return if (dp[y] == Integer.MAX_VALUE) -1 else dp[y]
    }
}