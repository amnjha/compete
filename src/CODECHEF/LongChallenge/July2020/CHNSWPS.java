import java.util.*;
class CHNSWPS {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T=s.nextInt();
        while (T-->0){
            int n = s.nextInt();
            Map<Long,Long> map = new HashMap<>();
            Map<Long,Long> map1 = new HashMap<>();
            Map<Long,Long> map2 = new HashMap<>();
            long min = Integer.MAX_VALUE;
            long A[]=new long[n];
            long B[]=new long[n];
            for (int i = 0; i <n ; i++) {
                A[i]=s.nextLong();
                min=Math.min(A[i],min);
                map.put(A[i],map.getOrDefault(A[i],0L)+1);
            }
            for (int i = 0; i <n ; i++) {
                B[i] = s.nextLong();
                min = Math.min(B[i],min);
                map.put(B[i],map.getOrDefault(B[i],0L)+1);
            }
            long f=0;
            for(Map.Entry<Long,Long> mm:map.entrySet()){
                if(mm.getValue()%2==1){
                    f=1;
                    break;
                }
                else{
                    long val= mm.getValue()/2;
                    map1.put(mm.getKey(),val);
                }
            }
            if(f==1){
                System.out.println(-1);
            }
            else{
                map2.putAll(map1);
                List<Long> list1=new ArrayList<>();
                List<Long>list2=new ArrayList<>();
                for (int i = 0; i <n ; i++) {
                    if(map1.get(A[i])!=0)
                        map1.put(A[i],map1.get(A[i])-1);
                    else
                        list1.add(A[i]);
                }
                for (int i = 0; i <n ; i++) {
                    if(map2.get(B[i])!=0)
                        map2.put(B[i],map2.get(B[i])-1);
                    else
                        list2.add(B[i]);
                }
                Collections.sort(list1);
                Collections.sort(list2,Collections.reverseOrder());
                int size= list1.size();
                if(size==0)
                    System.out.println(0);
                else{
                    long ans=0;
                    for (int i = 0; i <size ; i++) {
                        ans+=Math.min(2*min,Math.min(list1.get(i),list2.get(i)));
                    }
                    System.out.println(ans);
                }
            }

        }
    }
}