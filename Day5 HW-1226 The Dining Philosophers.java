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

    // call the run() method of any runnable to execute its code
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

        // Lock both forks
        forks[leftForkIndex].lock();
        forks[rightForkIndex].lock();

        try {
            // Execute eating actions
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
        } finally {
            // Unlock forks and release semaphore permit
            forks[rightForkIndex].unlock();
            forks[leftForkIndex].unlock();
            limit.release();
        }
    }
}
