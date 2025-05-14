class Problem1 {
    public int peakIndexInMountainArray(int[] arr) {
        return peak(arr, 0, arr.length - 1);
    }

    public int peak(int[] arr, int start, int end) {
        if (start == end) {
            return start;
        }
        int mid =start+(end-start)/2;
        if (arr[mid]>arr[mid+1]) {
            return peak(arr, start, mid);
        } else {
            return peak(arr, mid + 1, end);
        }
    }
}