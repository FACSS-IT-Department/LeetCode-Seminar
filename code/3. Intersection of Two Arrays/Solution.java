class Solution {
       
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n: nums2) set2.add(n);
        
        if (set1.size() < set2.size()) return intersectionSet(set2, set1);
        else return intersectionSet(set1, set2);
    }
    
    public int[] intersectionSet(HashSet<Integer> set1, HashSet<Integer> set2){
        int [] output = new int[set1.size()];
        int i = 0;
        for (Integer s:set1){
            if(set2.contains(s)) output[i++] =s ;
        }
        return Arrays.copyOf(output,i);
    }
}
