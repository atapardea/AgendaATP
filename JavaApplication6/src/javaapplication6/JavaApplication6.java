/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

/**
 *
 * @author atapardea
 */
public class JavaApplication6 {

	public static void main(String[] args){
		try{
			System.out.print("a");
			f();
			System.out.print("c");
		}catch(Exception e){
			System.out.print(e.getMessage());
			System.out.print("d");
		}
		System.out.print("e");
	}
	private static void f() {
		throw new RuntimeException("b");
	}
}
