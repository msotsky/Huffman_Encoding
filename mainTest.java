import java.util.*;
import java.text.*;

public class mainTest {
    
    public static void main(String[] args) {
        public FrequencyCount(String string) {
            Enumeration enumer;
            StringCharacterIterator strit = new StringCharacterIterator(string);
            char ch;
    
            /* This is ugly. I wish chars and ints were Objects.
             * Is there a better way to do this? */
    
            for (ch = strit.first(); 
                    ch != CharacterIterator.DONE; 
                    ch = strit.next()) {
                    Character chr = new Character(ch);
                    if (!map.containsKey(chr)) {
                        map.put(chr, new Integer(1));
                    } 
                    else {
                        int i = ((Integer)map.get(chr)).intValue() + 1;
                        map.put(chr, new Integer(i));
                    }
            }
    }
}
