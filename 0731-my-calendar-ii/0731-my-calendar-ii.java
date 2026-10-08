class MyCalendarTwo {

    List<int[]> bookings;
    List<int[]> overlapBookings;

    public MyCalendarTwo() {
        bookings = new ArrayList<int[]>();
        overlapBookings = new ArrayList<int[]>();
    }

    public boolean overlap(int[] i1, int s2, int e2) {
        int s1 = i1[0];
        int e1 = i1[1];

        return s1 < e2 && s2 < e1;
    }

    public boolean book(int startTime, int endTime) {

        // First check:
        // Kya new booking already kisi double-overlap
        // wale interval se overlap kar rahi hai?
        for (int i = 0; i < overlapBookings.size(); i++) {
            if (overlap(overlapBookings.get(i), startTime, endTime)) {
                return false;
            }
        }

        // Existing bookings ke saath overlap find karo
        // aur unka intersection overlapBookings mein daalo
        for (int i = 0; i < bookings.size(); i++) {

            if (overlap(bookings.get(i), startTime, endTime)) {

                overlapBookings.add(new int[] {
                    Math.max(bookings.get(i)[0], startTime),
                    Math.min(bookings.get(i)[1], endTime)
                });
            }
        }

        // Normal booking add karo
        bookings.add(new int[] {
            startTime,
            endTime
        });

        return true;
    }
}