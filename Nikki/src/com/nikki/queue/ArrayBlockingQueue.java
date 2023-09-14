package com.nikki.queue;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, java.io.Serializable {
    /** 队列元素 */
    final Object[] items;

    /** 下一次读取操作的位置, poll, peek or remove */
    int takeIndex;

    /** 下一次写入操作的位置, offer, or add */
    int putIndex;

    /** 元素数量 */
    int count;
    
    /*
     * Concurrency control uses the classic two-condition algorithm
     * found in any textbook.
     * 它采用一个 ReentrantLock 和相应的两个 Condition 来实现。
     */

    /** Main lock guarding all access */
    final ReentrantLock lock;

    /** Condition for waiting takes */
    private final Condition notEmpty;

    /** Condition for waiting puts */
    private final Condition notFull;
    
    /** 指定大小 */
    public ArrayBlockingQueue(int capacity) {
        this(capacity, false);
    }
    
    /** 
     * 指定容量大小与指定访问策略 
     * @param fair 指定独占锁是公平锁还是非公平锁。非公平锁的吞吐量比较高，公平锁可以保证每次都是等待最久的线程获取到锁；
     */
    public ArrayBlockingQueue(int capacity, boolean fair) {
		this.lock = new ReentrantLock();
		this.notEmpty = null;
		this.notFull = null;
		this.items = null;}
    
    /** 
     * 指定容量大小、指定访问策略与最初包含给定集合中的元素 
     * @param c 将此集合中的元素在构造方法期间就先添加到队列中 
     */
    public ArrayBlockingQueue(int capacity, boolean fair,
                              Collection<? extends E> c) {
								this.lock = new ReentrantLock();
								this.notEmpty = null;
								this.notFull = null;
								this.items = null;}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int drainTo(Collection<? super E> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int drainTo(Collection<? super E> arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean offer(E arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offer(E arg0, long arg1, TimeUnit arg2) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E poll(long arg0, TimeUnit arg1) throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(E arg0) throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int remainingCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E take() throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}
