
public class Pair<K, V> {

    K first;
    V second;

    /**
     * Constructor
     */
    public Pair(K first, V second){
        this.first = first;
        this.second = second;
    }

    //Getters
    public K getFirst(){
        return this.first;
    }

    public V getSecond(){
        return this.second;
    }

    //Setters
    public void setFirst(K first){
        this.first = first;
    }

    public void setSecond(V second){
        this.second = second;
    }

    @Override
    public String toString() {
        return this.first + " : " + this.second;
    }

    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Pair<?, ?> other = (Pair<?, ?>) obj;
        if (this.first.equals(other.getFirst()) && this.second.equals(other.getSecond())){
            return true;
        }
        return false;
    }

    public int hashCode(){
        if (this != null){
            return this.hashCode();
        }
        return 0;
    }
}
