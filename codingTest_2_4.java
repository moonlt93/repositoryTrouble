import java.util.Arrays;

public class codingTest_2 {
    public static void main(String[] args) {

    }

    public int solution(int[] buckets, int m) { // 이분탐색 사용하는 문제 > 유사 문제는 백준 2110번 공유기 설치
        int answer = 0;
        Arrays.sort(buckets);
        int min = 1;
        int max = buckets[buckets.length-1]-buckets[0];
        int mid = 0;

        while(min<=max) {
            mid = (min + max) / 2;
            int start = buckets[0];
            int count = 1;
            for(int i = 0; i< buckets.length; i++) {
                int dist = buckets[i] - start;
                if(dist >= mid) {
                    count++;
                    start = buckets[i];
                }
            }
            if(count >= m) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        answer = max;
        return answer;
    }
    
        public int solution(int[] numsDivide, int[] numsDivided) { // 4번 문제
        int answer = 0;
        int a = numsDivided[0];
        for(int i : numsDivided) {
            a = gcd(a, i);
        }
        int min = Integer.MAX_VALUE;
        for(int n : numsDivide) {
            if(a % n == 0) {
                min = Math.min(min, n);
            }
        }
        for(int n : numsDivide) {
            if(n < min) {
                ++answer;
            }
        }
        if(min == Integer.MAX_VALUE) {
            answer = -1;
        }
        return answer;
    }

    public int gcd(int a, int b) {
        while (b > 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

}
