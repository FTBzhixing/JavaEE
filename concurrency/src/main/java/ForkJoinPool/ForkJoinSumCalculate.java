package ForkJoinPool;

import java.util.concurrent.RecursiveTask;

//RecursiveTask有返回值RecursiveAction没有返回值
public class ForkJoinSumCalculate extends RecursiveTask<Long> {

    private long start;
    private long end;

    private static final long THURSHOLD = 0L;//临界值

    public ForkJoinSumCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length=end-start;
        if(length<=THURSHOLD){
            long sum=0L;
            for (long i = start; i <=end; i++) {
                sum+=i;
            }
            return sum;
        }else {
            long middle = (start+end)/2;
            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start, middle);
            left.fork();//进行拆分，同时压入线程队列
            ForkJoinSumCalculate right = new ForkJoinSumCalculate(middle + 1, end);
            right.fork();
            return left.join()+right.join();
        }

    }
}
