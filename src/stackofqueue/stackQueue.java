package stackofqueue;

import java.util.ArrayDeque;
import java.util.Queue;

/*
//��ĿҪ������������ʵ��ջ
˼·��push:�������벻Ϊ�յ���һ������������Ϊ�գ����������һ�����stack1����
     popo:��������Ϊ�գ����׳��쳣
          �϶���һ����Ϊ�գ���˽���Ϊ�յ�Ԫ��ת�Ƶ���һ��ջ�У�ֱ����ջֻʣ��һ��Ԫ�أ��򵯳���Ԫ�ء�

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