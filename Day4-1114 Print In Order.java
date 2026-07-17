import java.util.concurrent.Semaphore;

class Foo {
    private Semaphore runTwo;
    private Semaphore runThree;

    public Foo() {
        // Initialize both semaphores with 0 permits so acquire() blocks initially
        runTwo = new Semaphore(0);
        runThree = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        
        // Release a permit to allow second() to run
        runTwo.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // Wait for first() to finish and release the permit
        runTwo.acquire();
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        
        // Release a permit to allow third() to run
        runThree.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // Wait for second() to finish and release the permit
        runThree.acquire();
        
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
