package com.FunctionalInterface;

//Demo.java

//@FunctionalInterface is OPTIONAL.
//It is used only to CHECK that this interface has exactly ONE abstract method.

@FunctionalInterface
interface Demo
{
 // Abstract Method
 // Only declaration, no body.
 // A Functional Interface must have ONLY ONE abstract method.
 void display();

 // Default method
 // Has a body.
 // Does NOT count as an abstract method.
 default void show()
 {
     System.out.println("Default Method");
 }

 // Static method
 // Has a body.
 // Does NOT count as an abstract method.
 static void test()
 {
     System.out.println("Static Method");
 }

 /*
   If you add another abstract method like below:

   void print();

   Then:

   WITH @FunctionalInterface
   -------------------------
   Compile Error:
   "Demo is not a functional interface"

   WITHOUT @FunctionalInterface
   ----------------------------
   No Compile Error.
   It simply becomes a NORMAL interface
   because it now has 2 abstract methods.
 */
}
