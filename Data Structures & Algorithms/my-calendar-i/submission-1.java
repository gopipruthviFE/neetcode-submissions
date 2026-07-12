class MyCalendar {
    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
       Integer prevKey = map.floorKey(startTime);
       Integer nextKey = map.ceilingKey(startTime);

       if(prevKey != null && map.get(prevKey) > startTime){
        return false;
       }else if(nextKey != null && nextKey < endTime){
        return false;
       } else{
        map.put(startTime, endTime);
       }
       return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */