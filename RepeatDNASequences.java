class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<Long> alSeq = new HashSet<>();
        HashSet<String> result = new HashSet<>();

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A',1);
        map.put('G',2);
        map.put('T',3);
        map.put('C',4);

        long hash = 0;

        long posFac = (long) Math.pow(4,10);
        for(int i=0;i<s.length();i++){
            char in = s.charAt(i);
            hash= hash*4 + map.get(in);

            if(i>=10){
                char out = s.charAt(i-10);
                hash = hash -(posFac * map.get(out));
            }

            if(alSeq.contains(hash)){
                result.add(s.substring(i-9, i+1));
            }else{
                alSeq.add(hash);
            }
        }
        return new ArrayList<>(result);
    }
}