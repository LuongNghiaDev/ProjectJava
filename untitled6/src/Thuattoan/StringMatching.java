package Thuattoan;

public class StringMatching {
    //algorithm KMP - tìm chuỗi giống nhau
    void kmpSearch(String pat,String txt){
        int m = pat.length();
        int n = txt.length();

        int lps[] = new int[m];
        int j=0;

        compute(pat,m,lps);
        int i=0;
        while (i < n){
            if(pat.charAt(j) == txt.charAt(i)){
                j++;
                i++;
            }
            if(j==m){
                System.out.println("Đc tìm thấy tại chỉ mục: "+(i-j));
                j= lps[j-1];
            }

            else if(i < n && pat.charAt(j) != txt.charAt(i)){
                // Không khớp với các ký tự lps [0..lps [j-1]],
                if(j != 0){
                    j = lps[j-1];
                }else {
                    i = i+1;
                }
            }
        }
    }
    void compute(String pat,int m,int lps[]){
        int len=0;
        int i=1;
        lps[0]=0;

        while (i < m){ //vòng lặp tính toán lps [i] cho i = 1 đến M-1
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else {
                if(len != 0){
                    len = lps[len-1];
                    //ko tăng
                }else {
                    lps[i]=len;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        new StringMatching().kmpSearch(pat, txt);
    }
}

class RabinKarp{
    //String Matching
    //0(n-m+1)
    public static int d =256;

    static void search(String pat,String txt,int q){
        int m = pat.length();
        int n = txt.length();

        int i,j;
        int p=0; //giá trị băm cho pat
        int t=0; //giá trị băm cho txt
        int h=1;

        //giá trị của h là pow(d,m-1)%q
        for (i=0;i<m-1;i++){
            h = (h*d)%q;
        }

        //tính gía trị băm của pat và txt
        for (i=0;i<m;i++){
            p= (d*p + pat.charAt(i)) %q;
            t= (d*t + txt.charAt(i)) %q;
        }
        //duyệt
        for (i=0;i<n-m;i++){
            //kiểm tra băm ,từng kí tự
            if(p == t){
                for (j=0;j<m;j++){

                    if(txt.charAt(i+j) != pat.charAt(j)){
                        break;
                    }
                }
                if(j == m){
                    System.out.println("Pattern found at index " + i);
                }
            }

            if(i <n-m){
                //tính giá trị băm tiếp theo
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;

                if(t < 0){
                    t=t+q;
                }
            }
        }
    }

    public static void main(String[] args) {
        String txt = "GEEKS FOR GEEKS";
        String pat = "GEEK";
        int q = 101; // 1 số nguyên tố
        search(pat, txt, q);
    }
}
