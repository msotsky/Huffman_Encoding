/**
* This class represents an encoding for a FrequencyCount.
* This class provides a mapping between a character and a string.
*/

public class Encoding{
    /**
     * Create a new encoding for this FrequencyCount.
     * Initially, there will be no mappings between chars and strings.
     */
    private static Hashtable<Character,String> map = new Hashtable<>();

    public Encoding(FrequencyCount fcount) {
        //super(fcount.getCharArray().length);
        //super(fcount.getCharArray().toString());
        //PriorityQueue pq = new PriorityQueue(fcount.charCount());
    }

    /**
     * Set the encoding for this char to the specified string.
     * In this assignment, the string will consist (of ones and zeros)
     */

    public void setCode(PriorityQueue pq) {
        postOrderSub(pq.removeMin(),"");
    }

    /**
     * return the code string for this character.
     */
    public static String getCode(char ch) {
        return map.get(ch);
    }
    
    /**
     * Return the FrequencyCount that this encoding is for.
     */
    //public FrequencyCount getFcount() {
        //return map.size();
        //return fcount;
    }

    public static String encode(FrequencyCount frequency){
        String product = "";
        char[] arr = frequency.getCharArray();
        for(int i = 1; i < frequency.charCount(); i++){
            product = product + String.valueOf(arr[i]);
        }
        return product;
    }
    public static void postOrder(PriorityQueue pq){
        postOrderSub(pq.removeMin(),"");
    }

    private static void postOrderSub(Node current, String code){
        if(current != null){
            postOrderSub(current.getLeftNode(),code.concat("0"));
            postOrderSub(current.getRightNode(),code.concat("1"));
            if(current.isLeaf()){
                map.put(current.getChar(),code); 
            }
        }
    }
    public static void main(String[] args) {
        String str = "peter pipers peppers";
        Huffman encoder = new Huffman();
        Encoding enc;
        FrequencyCount fcount = new FrequencyCount(str);
        enc = encoder.encode(fcount);
        System.out.println(enc.getCode('p'));

        //String str = "peter pipers peppers";
        //FrequencyCount fcount = new FrequencyCount(str);
        //encode(fcount);
        //System.out.println(map);
    }
}
