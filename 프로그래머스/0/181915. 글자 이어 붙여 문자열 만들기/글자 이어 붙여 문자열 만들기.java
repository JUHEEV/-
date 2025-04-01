class Solution {
    public String solution(String my_string, int[] index_list) {
        String result = "";
        
        for (int i = 0; i < index_list.length; i++) {
            int index = index_list[i];
            result = result + my_string.charAt(index);
        }
        
        return result;
    }
}