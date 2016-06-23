import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author Valentino Muiruri
 * Personal sort function and binary search function
 */
public class SearchAlgorithm {
    
    public static boolean AlgorithmA(int [] setS, int x){
		int [] newSet = new int[setS.length];
		
		//store the values in newSet
		for (int row = 0; row < setS.length; row++){
			newSet[row] = setS[row];
		}
		//search newSet for value of x and each position
		//if x value is found, return true, else return false
		for(int i = 0; i<newSet.length; i++){
			if (newSet[i] == x){
				return true;
			}
		}
		return false;
	}
	
	public static boolean AlgorithmB(int [] setS, int x){
                int lastV = setS[((setS.length) - 1)];
                int [] leftC;
                int [] rightC;
                int leng = setS.length-1;
                int count = 0;
                int c1 = 0;
                int c2 = 0;
                int [] SetS1 = new int[setS.length];
                int [] FinalArray = new int[setS.length];
		for (int i = 0; i < leng; i++){
                    if(setS[i] <= lastV){
                        c1++;
                    }else{
                        c2++;
                    }
		}
                leftC = new int[c1];
                rightC = new int[c2];
                //split up the array into two unsorted arrays
                int j = 0;
                int k = 0;
                for(int p = 0; p < leng; p++){
                    if(setS[p] <= lastV){
                        leftC[j] = setS[p];
                        j++;
                            }
                    else{
                        rightC[k] = setS[p];
                        k++;
                    }
                }
                //sort each array
                Arrays.sort(rightC);
                Arrays.sort(leftC);
                //add them together now
                int row;
                for(row = 0; row < leftC.length; row++)
                    FinalArray[row] = leftC[row];
                FinalArray[row] = lastV;
                row++;
                for(int i = 0; i < rightC.length; i++)
                    FinalArray[row + i] = rightC[i]; 
                //search sorted set
                if (setS.length == 1){
                    return true;
                }
        	for(int i = 0; i<FinalArray.length; i++){
			if (FinalArray[i] == x){
				return true;
			}
		}
		return false;
	}
        
    public static int randomFill(){
    Random rand = new Random();
    int randomNum = rand.nextInt();
    if (randomNum %2 == 0)
        return randomNum;
    return randomFill();
    }
    public static void main(String[] args) {
        //n values for testing
        int n = 1000;
        //int n = 2000;
        //int n = 5000;
        //int n = 10000;
        int [] k = new int[500];
        int [] t1 = new int [n];

        for (int i = 0; i < n; i++){
            t1[i] = randomFill();
        }
        //fill array k with values
        for (int i = 0; i < 250; i++){
            k[i] = randomFill();
        }
        int j = 250;
        for(int i = 0; i <250; i++){
            k[j] = t1[i];
            j++;
        }
        
        //test 1 with algorithm A
        
        for(int i = 0; i < 500; i++){
            long startTime = System.nanoTime();
            AlgorithmA(t1, k[i]);
            long endTime = System.nanoTime();
            System.out.println(endTime - startTime);
        }
        //test 2 for algorithm B
        for(int i = 0; i < 500; i++){
            long startTime = System.nanoTime();
            AlgorithmB(t1, k[i]);
            long endTime = System.nanoTime();
            System.out.println(endTime - startTime);
        }
    }
    
}
