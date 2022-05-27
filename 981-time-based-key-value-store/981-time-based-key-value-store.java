class TimeMap {
    HashMap<String, List<TimeValue>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new TimeValue(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<TimeValue> list = map.get(key);
        if (list == null || timestamp < list.get(0).timestamp) {
            return "";
        }
        int left = 0, right = list.size() - 1;
        String result = "";
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (list.get(mid).timestamp == timestamp) {
                return list.get(mid).value;
            } else if (list.get(mid).timestamp < timestamp) {
                result = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}

class TimeValue {
    public String value;
    public int timestamp;

    public TimeValue(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}
