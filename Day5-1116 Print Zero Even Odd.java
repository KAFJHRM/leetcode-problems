import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private Semaphore zeroSem;
    private Semaphore oddSem;
    private Semaphore evenSem;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.zeroSem = new Semaphore(1); // Starts with 1 to print '0' first
        this.oddSem = new Semaphore(0);
        this.evenSem = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSem.acquire();
            printNumber.accept(0);
            
            // If the next number to be printed is odd, release oddSem; otherwise evenSem
            if (i % 2 != 0) {
                oddSem.release();
            } else {
                evenSem.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSem.acquire();
            printNumber.accept(i);
            zeroSem.release(); // Hand control back to zero
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSem.acquire();
            printNumber.accept(i);
            zeroSem.release(); // Hand control back to zero
        }
    }
}
