/**
 * Zigzag Conversion
 */
class Solution {
    public String convert(String s, int numRows) {
        int dy = 1;
        int idx = -1;
        ArrayList<Character>[] arr = new ArrayList[numRows];

        for(int i=0; i<numRows; i++) {
            arr[i] = new ArrayList<Character>();
        }

        for(int i=0; i<s.length(); i++) {
            if(idx + dy < 0 || idx + dy >= numRows) {
                dy = -dy;
            }
            if(numRows > 1) {
                idx = idx + dy;
            } else {
                idx = 0;
            }
            arr[idx].add(s.charAt(i));
        }

        StringBuilder builder = new StringBuilder();
        for(int i=0; i<numRows; i++) {
            for(Character ch: arr[i]){
                builder.append(ch);
            }
        }

        return builder.toString();
    }
}
