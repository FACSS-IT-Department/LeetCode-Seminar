class Solution {
    private HashMap<Character,Character> mapping;
    public Solution(){
        this.mapping = new HashMap<Character,Character>();
        this.mapping.put(')','(');
        this.mapping.put(']','[');
        this.mapping.put('}','{');
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for( int i = 0; i < s.length(); i++){
            
            char a = s.charAt(i);
            //closing bracket
            if(this.mapping.containsKey(a)){
                char top = stack.empty()? 'q':stack.pop();
                if(top != this.mapping.get(a)){
                    return false;
                }
            }
            //opening bracket
            else{
                stack.push(a);
            }
            
        }
        return stack.isEmpty();
    }
}