class IntersectionArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] map = new int[1001];  
        for (int num : nums1) {
            map[num] = 1;  
        }
        int[] temp = new int[nums2.length];
        int index = 0;
        for (int num : nums2) {
            if (map[num] == 1) {
                temp[index++] = num; 
                map[num] = 0;  
            }
        }
        int[] result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    public static void main(String[]args) {
        int[]nums1 = {1, 2, 2, 1};
        int[]nums2 = {2, 2};
        intersection(nums1, nums2);
    }
}
