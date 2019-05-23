package stackofqueue;

import java.util.ArrayDeque;
import java.util.Queue;

/*
//题目要求：用两个队列实现栈
思路：push:将数放入不为空的那一个，若两个均为空，则放入任意一个里（先stack1）。
     popo:若两个均为空，则抛出异常
          肯定有一个不为空，因此将不为空的元素转移到另一个栈中，直到该栈只剩下一个元素，则弹出此元素。

*/

public class stackQueue {
	
	static Queue<Integer> queue1 = new ArrayDeque<Integer>();
	static Queue<Integer> queue2 = new ArrayDeque<Integer>();
	
	public static void push(int node) {
		if(!queue1.isEmpty())
			queue1.offer(node);
		else
			queue2.offer(node);
	}
	
	public static int pop() {
		if(queue1.isEmpty()&&queue2.isEmpty())
			throw new RuntimeException("The Stack is empty.");
		
		if(queue1.isEmpty()) {
			while(queue2.size()>1)
				queue1.offer(queue2.poll());
			return queue2.poll();
		}
		else {
			while(queue1.size()>1)
				queue2.offer(queue1.poll());
			return queue1.poll();
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		push(2);
		push(5);
		push(0);
		push(1);
		push(3);
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		

	}

}