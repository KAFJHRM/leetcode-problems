import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {
    // 5 locks representing the 5 forks
    private final ReentrantLock[] forks;
    // Limit the number of philosophers trying to eat concurrently to 4
    private final Semaphore limit;

    public DiningPhilosophers() {
        forks = new ReentrantLock[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
        // Allowing maximum 4 philosophers to try to pick up forks at the same time
        limit = new Semaphore(4);
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        
        int leftForkIndex = philosopher;
        int rightForkIndex = (philosopher + 1) % 5;

        // Acquire permit before attempting to pick up forks
        limit.acquire();

        // Lock both forks to ensure exclusive access
        forks[leftForkIndex].lock();
        forks[rightForkIndex].lock();

        try {
            // Execute the required operations in order
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
        } finally {
            // Always unlock the forks in the finally block to prevent leaks
            forks[leftForkIndex].unlock();
            forks[rightForkIndex].unlock();
            
            // Release the semaphore permit so another philosopher can step up
            limit.release();
        }
    }
}
