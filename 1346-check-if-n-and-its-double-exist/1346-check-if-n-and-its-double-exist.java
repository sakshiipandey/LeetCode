class Solution {
public boolean checkIfExist(int[] arr) {
int i = 0;
int j = 1;

    while(i < arr.length) {
        j = 0;

        while(j < arr.length) {
            if(i != j) {
                if(arr[i] == 2 * arr[j]) {
                    return true;
                }
            }
            j++;
        }
        i++;
    }

    return false;
}

}
