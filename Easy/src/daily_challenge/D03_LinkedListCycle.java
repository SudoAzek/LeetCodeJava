package daily_challenge;

/*
* Given head, the head of a linked list, determine if the linked list has a cycle in it.
*
* There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following
* the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
* Note that pos is not passed as a parameter. Return true if there is a cycle in the linked list. Otherwise, return false.
 */

public class D03_LinkedListCycle {
    public static void main(String[] args) {
        LinkedListCycleSolution_1 linkedListCycleSolution_1 = new LinkedListCycleSolution_1();
//        linkedListCycleSolution_1.hasCycle()
    }
}


/**
 * Definition for singly-linked list.
 * */
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

 class LinkedListCycleSolution_1 {
     public boolean hasCycle(ListNode head) {                                     
         ListNode slower = head;                                                  
         ListNode faster = head;                                                  
                                                                                  
         while(slower != null && faster != null && faster.next != null) {         
             slower = slower.next;                                                
             faster = faster.next.next;                                           
                                                                                  
             if(slower != null && faster != null && slower.val == faster.val) {   
                 return true;                                                     
             }                                                                    
         }                                                                        
         return false;                                                            
     }                                                                            
 }