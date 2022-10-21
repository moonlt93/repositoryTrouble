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

}
