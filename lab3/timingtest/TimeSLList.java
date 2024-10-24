package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayList;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList <Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        for (int i = 0; i < 8; i += 1) {
            int num = (int) Math.pow(2, i);
            Ns.addLast(num * 1000);
            opCounts.addLast(10000);
        }
        for (int i = 0; i < Ns.size(); i += 1) {
            SLList <Integer> tmp = new SLList<>();
            for (int j = 0; j < Ns.get(i); j+= 1) {
                    tmp.addLast(j);
            }
            Stopwatch timer = new Stopwatch();
            for (int k = 0; k < opCounts.get(i); k += 1) {
                int tmp1 = tmp.getLast();
            }
            double sec = timer.elapsedTime();
            times.addLast(sec);
        }
        printTimingTable(Ns, times, opCounts);
    }

}

//package timingtest;
//import edu.princeton.cs.algs4.Stopwatch;
//
///**
// * Created by hug.
// */
//public class TimeSLList {
//    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
//        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
//        System.out.printf("------------------------------------------------------------\n");
//        for (int i = 0; i < Ns.size(); i += 1) {
//            int N = Ns.get(i);
//            double time = times.get(i);
//            int opCount = opCounts.get(i);
//            double timePerOp = time / opCount * 1e6;
//            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
//        }
//    }
//
//    public static void main(String[] args) {
//        timeGetLast();
//    }
//
//    public static void timeGetLast() {
//        AList<Integer> Ns = new AList<>();
//        AList<Double> times = new AList<>();
//        AList<Integer> opCounts = new AList<>();
//
//        int n = 1000, m = 10000;
//        for (int i = 0; i < 8; i++) {
//            SLList<Integer> lists = new SLList<>();
//            for (int j = 0; j < n; j++) {
//                lists.addLast(j);
//            }
//
//            Stopwatch sw = new Stopwatch();
//            for (int j = 0; j < m; j++) {
//                lists.getLast();
//            }
//            double time = sw.elapsedTime();
//
//            Ns.addLast(n);
//            times.addLast(time);
//            opCounts.addLast(m);
//
//            n = n * 2;
//        }
//
//        printTimingTable(Ns, times, opCounts);
//    }
//
//}