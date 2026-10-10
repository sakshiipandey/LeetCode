class MyCalendar {
    TreeMap<Integer, Integer>map;

    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        int bookings=0;
        //add this booking to treemap
        map.put(startTime,map.getOrDefault(startTime,0)+1);
        map.put(endTime,map.getOrDefault(endTime, 0)-1);
        //run line sweep algorithm & check if bookings>1
        //it means that this booking is causing double booking
        //undo change
        //return false


        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            bookings += entry.getValue();
            if(bookings>1){
                map.put(startTime,map.get(startTime)-1);
                map.put(endTime,map.get(endTime)+1);
                if(map.get(startTime)==0){
                    map.remove(startTime);
                }
                if(map.get(endTime)==0){
                    map.remove(endTime);
                }
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */