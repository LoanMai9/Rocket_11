package com.vti.academy.frontend;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.vti.academy.entity.Collection.StackAndQueue.Student;

public class StackProgram {
	public static void main(String[] args) {
		inStack();
		inQueue();
	}
	public static void inStack() {
		Stack<String> st = new Stack<>();
		//Stack<Student> st = new Stack<>();
		st.push( "Nguyễn văn Nam");
		st.push("Nguyễn Văn Huyên");
		st.push("Trần Văn Nam");
		st.push("Nguyễn Văn A");
		
//		for (Student student : st) {
//			System.out.println(st.pop());
//		}
		int n = st.size();
		for (int i = 0; i < n; i++) {
			System.out.println(st.pop());
		}
	}
	public static void inQueue() {
		Queue<String> que = new LinkedList<>();
		que.add("Nguyễn văn Nam");
		que.add("Nguyễn Văn Huyên");
		que.add("Trần Văn Nam");
		que.add("Nguyễn Văn A");
		int n= que.size();
		for (int i = 0; i < n; i++) {
			System.out.println(que.poll());// vì poll lấy ra 1 phần tử thì xóa đi 
		}
		
	}
}
