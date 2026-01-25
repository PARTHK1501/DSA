class TimeMap {

    private Map<String,TreeMap<Integer,String>> m;

    public TimeMap() {
        m = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        m.computeIfAbsent(key,k->new TreeMap<>()).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(!m.containsKey(key)) return "";

        TreeMap<Integer,String> timestamps = m.get(key);
        Map.Entry<Integer,String> entry = timestamps.floorEntry(timestamp);

        return entry == null ? "" : entry.getValue();
    }
}

//2nd - Method

class TimeMap{
    private Map<String,List<Pair<Integer,String>>> keyStore;

    public static class Pair<K,V>{
        private static final K key;
        private static final V value;

        public Pair(K key,V values){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }
    }

    public TimeMap() {
        keyStore = new HashMap<>();
    }

    public void set(String key,String value,int timestamp){
        keyStore.computeIfAbsent(key,k->new ArrayList<>()).add(new Pair<>(timeStamp,value));
    }
    
    public String get(String key,int timestamp){
        List<Pair<Integer,String>> values = keyStore.getOrdefault(key,new ArrayList<>());

        int low = 0,high = values.size()-1;
        String result = "";

        while(low<=high){

            int mid = low + (high-low)/2;

            if(values.get(mid).getKey() <= timestamp){
                result = values.get(mid).getValue();
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return result;
    }
}