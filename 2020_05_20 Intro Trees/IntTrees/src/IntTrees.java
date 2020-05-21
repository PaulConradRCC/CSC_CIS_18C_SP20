/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

public class IntTrees {

    public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      IntTree tree = new IntTree( );

      System.out.println("Enter a list of nonnegative integers.");
      System.out.println("Place a negative integer at the end.");
      int next = keyboard.nextInt( );
      while (next >= 0)
      {
          tree.add(next);
          next = keyboard.nextInt( );
      }

      System.out.println("Pre order traversal:");
      tree.preorder();
      
      System.out.println("In order traversal:");
      tree.inorder();
      
      System.out.println("Post order traversal:");
      tree.postorder();
   }
}