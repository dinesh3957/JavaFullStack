package com.FunctionalInterface;
//Class implementing the interface
class MyClass implements Demo
{
 @Override
 public void display()
 {
     System.out.println("Abstract Method Implemented");
 }
}

//Main Class
public class Test
{
 public static void main(String[] args)
 {
     MyClass obj = new MyClass();

     // Calling abstract method implementation
     obj.display();

     // Calling default method
     obj.show();

     // Calling static method
     Demo.test();
 }
}
