package LeetCode;


import Cautruc.LinkendList;

import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Baitap {
    //tim chuoi dai nhat
    public int leng(String s) {
        int n = s.length();
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (check(s, i, j)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    public boolean check(String s, int start, int end) {
        int[] chars = new int[128];

        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            chars[c]++;
            if (chars[c] > 1) {
                return false;
            }
        }
        return true;
    }

    //tinh trung binh 2 mang
    public static double find(int[] nums1, int[] nums2) {
        int[] Array = merga(nums1, nums2);
        int n = Array.length;
        if (n % 2 != 0) {
            return Array[n / 2];
        }
        int len = n / 2;
        int mid = len - 1;
        double res = (double) (Array[len] + Array[mid]) / 2;
        return res;
    }

    public static int[] merga(int[] nums1, int[] nums2) {
        int[] merga = new int[nums1.length + nums2.length];

        int lev = nums1.length;
        int prev = nums2.length;
        int i = 0, j = 0, k = 0;

        while (i < lev && j < prev) {
            if (nums1[i] <= nums2[j]) {
                merga[k++] = nums1[i];
                i++;
            } else {
                merga[k++] = nums2[j];
                j++;
            }
        }
        if (i < lev) {
            while (i < lev) {
                merga[k++] = nums1[i];
                i++;
            }
        }
        if (j < prev) {
            while (j < prev) {
                merga[k++] = nums2[j];
                j++;
            }
        }
        return merga;
    }

    //Thuật toán Manacher - Chuỗi con Palindromic dài nhất
    public static String getLongest(String s) {
        if (s.length() < 1 || s == null) {
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = checkLength(s, i, i);
            int len2 = checkLength(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    public static int checkLength(String s, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    //convert longest
    public static String convert(String s, int numbers){
        StringBuilder[] sb = new StringBuilder[numbers];
        for (int i=0;i<numbers;i++){
            sb[i]=new StringBuilder();
        }
        char[] arr = s.toCharArray();
        int n = arr.length;
        int index=0;
        while (index < n){
            for (int i=0;i<numbers && index <n ;i++){
                sb[i].append(arr[index++]);
            }
            for (int j=numbers-2;j>0 && index <n ;j++){
                sb[j].append(arr[index++]);
            }
        }
        StringBuilder ret = sb[0];
        for (int i=1;i<sb.length;i++){
            ret.append(sb.toString());
        }
        return ret.toString();
    }

    //reverse number
    public static int reverse(int x){
        //c1
        /*int result=0;
        while (x > 0){
            int pop = x%10;
            x/=10;
            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
                return 0;
            }
            result = result*10+pop;
        }
        return result; */

        //c2
        int sign=1;
        int result=0;
        if(x < 0){
            sign=-1;
            x=sign*x;
        }
        while (x > 0){
            if(result * sign > Integer.MAX_VALUE/10 || result*sign < Integer.MIN_VALUE/10){
                return 0;
            }
            result = 10 * result + x%10;
            x/=10;
        }
        return result*sign;
    }

    //chuyen kis tu thanh so
    public static int MyAtoi(String s){
        int sign=1;
        int n = s.length();
        int index=0;
        if(index < n && s.charAt(index) == ' '){
            index++;
        }
        if(index < n && s.charAt(index) == '+'){
            sign=1;
            index++;
        }else if(index < n && s.charAt(index) == '-'){
            sign=-1;
            index++;
        }
        int res=0;
        while (index < n && Character.isDigit(s.charAt(index))){
            int digit = s.charAt(index) - '0';
            if(res > Integer.MAX_VALUE/10 ||(res == Integer.MAX_VALUE/10 && digit> Integer.MAX_VALUE%10)){
                return sign==1?Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            index++;
        }
       return res*sign;
    }

    //palindrome
    public static boolean isPalindrome(int x){
        //c1
        int kq=x;
        int result=0;
        while (x > 0) {
            int pop = x % 10;
            x /= 10;
            result = result *10 + pop;
        }
        if(result == kq){
            return true;
        }
        return false;

    }

    //tra ve chuoi tien to dai nhat
    public static String longgestCommon(String[] s){
        if(s.length==0){
            return "";
        }
        String str = s[0];
        for (int i=1;i<s.length;i++){
            while (s[i].indexOf(str) != 0){
                str = str.substring(0,str.length()-1);
                if(str.isEmpty()){
                    return "";
                }
            }
        }
        return str;
    }

    //cong 3 so de dc tong gan voi target nhat
    public static int threeSum(int[] nums ,int target){
        Arrays.sort(nums);
        int n = nums.length;
        int cur = nums[0] + nums[1] + nums[n-1];
        int start=0,end=0;
        for (int i=0;i<n-2;i++){
            start = i + 1;
            end = n - 1;
            while (start < end) {
                int curSum = nums[i] + nums[start] + nums[end];
                if (curSum < target) {
                    start++;
                } else {
                    end--;
                }
                if (Math.abs(curSum - target) < Math.abs(cur - target)) {
                    cur = curSum;
                }
            }
        }
        return cur;
    }

    //kis tu chu cai tren so dt
    static String[] arr = {"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        generateCombinations(digits,"",res);
        return res;
    }

   public static void generateCombinations(String digits,String cur,List<String> res){
        if(cur.length() == digits.length()) return;

        int digit = digits.charAt(cur.length()) - '0';
        String str = arr[digit];
        for (int i=0;i<str.length();i++){
            if(cur.length() == digits.length()-1){
                res.add(cur + str.charAt(i));
            }else {
                generateCombinations(digits,cur + str.charAt(i),res);
            }
        }
   }

    //cong sum = target
    public static List<List<Integer>> fourSum(int[] nums , int target){
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 4){
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                int start=j+1;
                int end=n-1;
                int target2= target-nums[i]-nums[j];
                while (start < end){
                    int twoSum=nums[start]+nums[end];
                    if(twoSum < target2){
                        start++;
                    }else if(twoSum > target2){
                        end--;
                    }else {
                        ArrayList<Integer> find = new ArrayList<>();
                        find.add(nums[i]);
                        find.add(nums[j]);
                        find.add(nums[start]);
                        find.add(nums[end]);
                        res.add(find);
                        while (start < end && nums[start] == find.get(2)){
                            start++;
                        }
                        while (start < end && nums[start] == find.get(3)){
                            end--;
                        }
                    }
                }
                while (j+1<n && nums[j+1]==nums[j]) j++;
            }
            while (i+1<n && nums[i+1]==nums[i]) i++;
        }
        return res;
    }

    //xoa phan tu trong dslk
    public static ListNode remove(ListNode head,int n) {
        ListNode curNode=head;
        ListNode Nodehead=head;
        int length=0;

        while(Nodehead != null){
            length++;
            Nodehead = Nodehead.next;
        }
        int k = length-n;
        int cnt=0;
        if(k==0){
            head = head.next;
        }

        while (curNode != null){
            cnt++;
            if(cnt==k){
                curNode.next=curNode.next.next;
            }else {
                curNode = curNode.next;
            }
        }
        return head;
    }
    public static void print(ListNode head){
        if(head == null){
            System.out.println("empty");
        }else {
            ListNode temp = head;
            while (temp!=null){
                System.out.print(temp.val+" ");
                temp=temp.next;
            }
            System.out.println();
        }
    }

    //check ki tu
    public static boolean inValid(String s){
        String[] openClose = {"()","[]","{}"};

        StringBuilder sb = new StringBuilder();
        String c= null;
        for (int i=0;i<s.length();i++){
            sb.append(s.charAt(i));

            if(sb.length() >=2){
                c = sb.substring(sb.length()-2, sb.length());
                if(c.equals(openClose[0]) || c.equals(openClose[1]) || c.equals(openClose[2])){
                     sb.delete(sb.length()-2, sb.length());
                }
            }
        }
        if(sb.length()==0){
            return true;
        }else {
            return false;
        }
    }

    //hop nhat 2 lien ket
    public static ListNode mergaList(ListNode list1 ,ListNode list2){
        ListNode l = new ListNode();
        ListNode temp = l;

        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp.next=list1;
                list1=list1.next;
                temp=temp.next;
            }else {
                temp.next=list2;
                list2=list2.next;
                temp=temp.next;
            }
        }
        while (list1 != null){
            temp.next=list1;
            list1=list1.next;
            temp=temp.next;
        }
        while (list2 != null){
            temp.next=list2;
            list2=list2.next;
            temp=temp.next;
        }
        return l.next;
    }

    /*public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);

        n1.next=n2;
        n2.next=n3;

        ListNode h1 = new ListNode(6);
        ListNode h2 = new ListNode(9);
        ListNode h3 = new ListNode(3);

        h1.next=h2;
        h2.next=h3;

        ListNode list1 = n1;
        ListNode list2 = h2;

        ListNode rem = mergaList(list1,list2);
        print(rem);

    }*/

}
