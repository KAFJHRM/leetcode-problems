import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    private Semaphore fooSem;
    private Semaphore barSem;

    public FooBar(int n) {
        this.n = n;
        // fooSem starts with 1 permit so 'foo' can run first
        this.fooSem = new Semaphore(1);
        // barSem starts with 0 permits so 'bar' has to wait
        this.barSem = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSem.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barSem.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSem.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSem.release();
        }
    }
}
