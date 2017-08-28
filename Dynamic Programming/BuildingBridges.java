import java.io.*;
import java.util.*;

public class BuildingBridges {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nor = new int[n];
        int[] sou = new int[n];
        for(int i =0;i<n;i++)
            nor[i]=in.nextInt();
        for(int i=0;i<n;i++)
            sou[i]=in.nextInt();
        City[] cities = new City[n];
        for(int i=0;i<n;i++)
            cities[i]=new City(nor[i], sou[i]);
        Arrays.sort(cities, City.com);
        int[] lis = new int[n];
        lis[0]=1;
        for(int i=1;i<n;i++){
            lis[i]=1;
            for(int j=0;j<i;j++){
                if(cities[j].north<=cities[i].north)
                    lis[i]=Math.max(lis[i], 1+lis[j]);
            }
        }
        int max = lis[0];
        for(int i=1;i<n;i++)
            max = Math.max(max, lis[i]);
        System.out.println(max);
    }
}
class City{
    int north,south;
    City(int n, int s){
        north = n;
        south =s;
    }
    static Comparator<City> com = new Comparator<City>() {
        @Override
        public int compare(City o1, City o2) {
            if(o1.south==o2.south)
                return o1.north-o2.north;
            return o1.south-o2.south;
        }
    };
}