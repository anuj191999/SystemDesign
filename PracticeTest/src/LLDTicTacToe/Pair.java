package LLDTicTacToe;

/**
 * Container to ease passing around a tuple of two objects. This object provides a sensible
 * implementation of equals(), returning true if equals() is true on each of the contained
 * objects.
 */
public class Pair{
        private Integer first;
        private Integer second;
        public Pair(Integer first, Integer second){
            this.first = first;
            this.second = second;

        }
        public Integer getFirst(){
            return first;
        }
        public Integer getSecond(){
            return second;
        }
        public void setFirst(Integer first){
            this.first = first;
        }
        public void setSecond(Integer second){
            this.second = second;
        }

}
