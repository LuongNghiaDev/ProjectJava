package Cautruc;

public class LinkendList {

      public static class Node{
          int value;
          Node next;
          Node(int value){
              this.value=value;
          }
      }
      public static void print(Node head){
          if(head == null){
              System.out.println("empty");
          }else {
              Node temp = head;
              while (temp!=null){
                  System.out.print(temp.value+" ");
                  temp=temp.next;
              }
              System.out.println();
          }
      }
      public static Node addHead(Node head,int value){
          Node newNode = new Node(value);
          if(head!=null){
              newNode.next=head;
          }
          return newNode;
      }
      public static Node addTail(Node head,int value){
          Node newNode = new Node(value);
          if(head==null){
              return newNode;
          }else{
              Node lastNode = head;
              while (lastNode.next!=null){
                  lastNode=lastNode.next;
              }
              lastNode.next=newNode;
          }
          return head;
      }
      public static Node addIndex(Node head,int value,int index){
          if(index==0){
              return addHead(head,value);
          }else {
              Node newNode = new Node(value);
              Node curNode = head;
              int count=0;
              while (curNode != null){
                  count++;
                  if(count==index){
                      newNode.next=curNode.next;
                      curNode.next=newNode;
                      break;
                  }
                  curNode=curNode.next;
              }
          }
          return head;
      }
      public static Node deleteNodeHead(Node head){
          if(head!=null){
              return head.next;
          }
          return head;
      }
      public static Node deleteNodetail(Node head){
          if(head==null){
              return null;
          }
          Node lastNode = head;
          Node prevNode = null; //con trỏ đứng trc lastNode

          while (lastNode.next != null){
              prevNode=lastNode;
              lastNode=lastNode.next;
          }
          if(prevNode==null){ //1 nốt
              return null;
          }else{
              prevNode.next=lastNode.next; //xóa
          }
          return head;
      }
      public static Node deleteIndex(Node head,int index){
          if(head==null || index < 0){
              return null;
          }
          if(index==0){
              return deleteNodeHead(head);
          }
          Node curNode = head;
          Node prevNode = null;
          int count=0;
          boolean found = false;
          while (curNode!=null){
              if(count==index){
                  found=true;
                  break;
              }
              prevNode=curNode;
              curNode=curNode.next;
              count++;
          }
          if(found){
               if(prevNode==null){ //curNode is lastNode
                   return null;
               }else{
                   if(curNode!=null){
                       prevNode.next=curNode.next;
                   }
               }
          }
          return head;
      }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next=n2;
        n2.next=n3;
        print(n1);

        n1 = deleteIndex(n1,0);
        print(n1);
        n1 = deleteIndex(n1,1);
        print(n1);
    //    n1 = deleteIndex(n1,1);
     //   print(n1);
    }
}

class testLink{
    public static class Node{
        int value;
        Node next;
        Node(int value){
            this.value=value;
        }
    }
    //đảo chiều
    public static Node List(Node head){
        Node cur = head;
        while (cur!=null && cur.next!=null){
            Node nextNode = cur.next;
            cur.next=nextNode.next;
            nextNode.next=head;
            head=nextNode;
        }
        return head;
    }
    public static void print(Node head){
        if(head == null){
            System.out.println("empty");
        }else {
            Node temp = head;
            while (temp!=null){
                System.out.print(temp.value+" ");
                temp=temp.next;
            }
            System.out.println();
        }
    }
    //đệ quy
    public static Node reverse(Node head){
        if(head==null){
            return null;
        }
        Node nextNode = head.next;
        if(nextNode==null){
            return head;
        }
        Node newHead = reverse(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next=n2;
        n2.next=n3;
        print(n1);

        Node newHead = reverse(n1);
        print(newHead);
    }
}
