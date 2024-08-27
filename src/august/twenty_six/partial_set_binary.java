package august.twenty_six;

public class partial_set_binary {
    public static void main(String[] args) {
        int arr[] = {3,6,7,1,5,4};
        int n = arr.length;

        for(int i = 0; i < (1 << n); i++){
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){
                    System.out.println(arr[j] + " " );
                }
            }
            System.out.println();
        }
    }
}
