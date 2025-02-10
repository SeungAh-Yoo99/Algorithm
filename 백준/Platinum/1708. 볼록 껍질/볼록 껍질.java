import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Point{
        long x;
        long y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static Point first = new Point(40_001, 40_001);

    // ccw 알고리즘
    // -1 := 시계 방향
    // 0 := 일직선
    // 1 := 반시계 방향
    static int ccw(Point a, Point b, Point c) {
        long ccwR = (a.x * b.y + b.x * c.y + c.x * a.y) - (b.x * a.y + c.x * b.y + a.x * c.y);

        if(ccwR > 0) return 1;
        if(ccwR < 0) return -1;
        return 0;
    }

    static long dist(Point a, Point b) {
        return (b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y);
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // Convex Hull 알고리즘

        // 점들 중 가장 왼쪽에 있는 점을 기준점(first)로 잡는다
        for(int i = 0; i < N; i++) {
            if(points.get(i).y < first.y) {
                first = points.get(i);
            }
            else if(points.get(i).y == first.y) {
                if(points.get(i).x < first.x)
                    first = points.get(i);
            }
        }

        // 기준점과 나머지 점들이 ccw로 반시계방향이 되도록 정렬
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point second, Point third) {
                int ccwR = ccw(first, second, third);
                if(ccwR > 0) // 반시계
                    return -1;
                else if(ccwR < 0) // 시계
                    return 1;
                else {
                    long distR1 = dist(first, second);
                    long distR2 = dist(first, third);

                    if(distR1 >  distR2) return 1;
                    else return -1;
                }
            }
        });

        // 그라함 스캔 알고리즘
        Stack<Point> stack = new Stack<>();
        stack.add(first);
        for (int i = 1; i < points.size(); i++) {
            // 시계방향이면 제거한다.
            while(stack.size() > 1
                && ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), points.get(i)) <= 0) {
                stack.pop();
            }
            stack.add(points.get(i));
        }

        System.out.println(stack.size());
    }
}