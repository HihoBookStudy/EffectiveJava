package javastudy.effectiveJava.Chapter2_CreatingAndDestroyingObjects.item13;

public class HashTable implements Cloneable{
    private Entry[] buckets;

    private static class Entry{
        final Object key;
        Object value;
        Entry next;

        public Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        Entry deepCopy(){
            return new Entry(key, value, next==null?null:next.deepCopy());
        }
    }

    @Override
    protected Object clone() {
        try{
            HashTable result = (HashTable) super.clone();
            result.buckets = new Entry[buckets.length];
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != null) {
                    result.buckets[i] = buckets[i].deepCopy();
                }
            }
            return result;
        } catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }
}
