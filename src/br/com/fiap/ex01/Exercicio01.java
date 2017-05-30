package br.com.fiap.ex01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Exercicio01 {

	public static void main(String[] args) throws InterruptedException {
		
		Runnable firstTaskWithoutScheduler = () -> { 
			for(String message : Arrays.asList("message 1", "message 2", "message 3")) {
				try {
					System.out.println("Thread[1]: " + message);
					Thread.sleep(20000);
				} catch (InterruptedException e) {
					
				}
			}
		};
		Thread firstThreadWithoutScheduler = new Thread(firstTaskWithoutScheduler);
		Runnable secondTaskWithoutScheduler = () -> { 
			while(true) {
				try {
					System.out.println("Thread[2]: " + DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss").format(LocalDateTime.now()));
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					
				}
			}
		};
		Thread secondThreadWithoutScheduler = new Thread(secondTaskWithoutScheduler);
		
		while (true) {
			System.out.println("Thread[1] - State: " + firstThreadWithoutScheduler.getState());
			System.out.println("Thread[2] - State: " + secondThreadWithoutScheduler.getState());

			if(firstThreadWithoutScheduler.getState().equals(Thread.State.NEW)) {
				firstThreadWithoutScheduler.start();
			}
			
			if(secondThreadWithoutScheduler.getState().equals(Thread.State.NEW)) {
				secondThreadWithoutScheduler.start();
			}
			Thread.sleep(5000);
		}
	}
}
