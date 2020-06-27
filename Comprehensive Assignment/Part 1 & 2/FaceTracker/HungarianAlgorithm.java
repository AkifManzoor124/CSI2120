package FaceTracker;

public class HungarianAlgorithm {

    int[][] costMatrix;
    int rowLenght;
    int columnLenght;

    //should I define row and column lenght here?
    
    public HungarianAlgorithm(int[][] costMatrix){
        this.costMatrix = costMatrix;
        this.rowLenght = costMatrix[0].length;
        this.columnLenght = costMatrix.length;
    }

    /**
     *  Row reduction 
     *      Find the smallest number in the row -> X
     *      Subtract each value within row by X
     *          There will be at least one zero in each row
     * @param costMatrix
     * @return
     */
    private int[][] step1(int[][] costMatrix){

        int minValue;

        for (int i = 0; i < columnLenght; i++) {

            minValue = costMatrix[i][0]; //the first element within the row

            for (int j = 0; j < rowLenght; j++) {               //Go through each element in the row and find the smallest num
                if(minValue > costMatrix[j][i]){                //Compare current minValue to all values within the row
                    minValue = costMatrix[j][i];                //if minValue is greater than current value, assign minValue to current value
                }
            }

            //Now that the min value is found, subtract minValue from each element within the row
            for(int k = 0; k < rowLenght; k++){
                costMatrix[i][k] = costMatrix[i][k] - minValue;
            }
        } //Do above for each row in the cost matrix

        return costMatrix;
    }

    /**
     *  Column reduction
     *      Find the smallest number in the column -> Y
     *      Subtract each value within column by Y
     * @param costMatrix
     * @return
     */
    private int[][] step2(int[][] costMatrix){
        
        int minValue;
        for (int i = 0; i < rowLenght; i++) {
            
            minValue = costMatrix[i][0]; //the first element within the column
            
            for (int j = 0; j < columnLenght; j++) {    //Go through each element in the column and find the smallest num
                if(minValue > costMatrix[j][i]){        //Compare current minValue to all values within the column
                    minValue = costMatrix[j][i];         //if minValue is greater than current value, assign minValue to current value
                }
            }

            //Now that the min value is found, subtract minValue from each element within the column
            for (int k= 0; k < columnLenght; k++) {
                costMatrix[k][i] = costMatrix[k][i] - minValue;
            }
        }

        return costMatrix;
    } //Do above for each column in the cost matrix


    /**
     * Test for an optimal Assignment
     *
     * Draw minimal number of lines to cover all 0s within the costMatrix
     * if number of lines drawn is equal to number of rows and columns, we can find an optimal assignment
     * @param costMatrix
     * @return
     */
    private boolean step3(int[][] costMatrix){
        boolean optimalAssignmentFlag = false;
        
        boolean first = false;
        boolean tickr = false;
        boolean ArcAssigned = false;
        boolean liner = false;
        boolean linec = false;
        boolean equal = false;

        //Step 3.a
        for (int i = 0; i < rowLenght; i++) {
            first = true;

            for(int j = 0; j < columnLenght; j++) {
                if(costMatrix[0][0] == 0){
                    if(first){
                        //A(r,c) is assigned
                        first = false;
                        //for rr in rows
                        //if A(rr,c) = 0 and != rr
                        //  A(rr,c) is crossed out
                    }
                }else{
                    //A(r,c) is crossed out
                    continue;
                }
            }
        }

        //step 3.b
        for (int i = 0; i < rowLenght; i++) {
            tickr = true;
            for(int j = 0; j < columnLenght; j++) {
                if(ArcAssigned = true){
                    tickr = false; 
                }
            }
        }

        //step 3.b
        for (int i = 0; i < rowLenght; i++) {
            if(!tickr){
                continue;
            }
            for(int j = 0; j < columnLenght; j++) {
                if(ArcAssigned = false){
                    tickr = true; 
                }
            }
        }

        //step 3.c
        for(int i = 0; i < columnLenght; i++) {
            if(!tickr){
                continue;
            }
            for (int j = 0; j < rowLenght; j++) {
                if(ArcAssigned = true){
                    tickr = false;
                }
            }
        }

        //step 3.d
        //Go back to step 3.b unless no new ticks were made

        //step 3.e
        for (int i = 0; i < rowLenght; i++) {
            if(!tickr){
                liner = true;
            }else{
                liner = false;
            }
        }
        for (int i = 0; i < columnLenght; i++) {
            if(!tickr){
                linec = true;
            }else{
                liner = false;
            }
        }        

        //if num of lines is equal to num of rows and columns, then set OptimalAssignmentFlag to True

        if(equal == true){
            optimalAssignmentFlag = true;
        }else{
            optimalAssignmentFlag = false;
        }

        return optimalAssignmentFlag;
    }


    /**
     * Shift the zeros within the matrix
     * 
     * Find smallest uncovered value -> Z
     * Subtract Z from all uncovered values
     * Add Z to values which intersect a line  
     * @param costMatrix
     * @return
     */
    private int[][] step4(int[][] costMatrix){

        return costMatrix;
    }
    

    /**
     * Find exactly one zero entry from each row and column
     * @param costMatrix
     * @return
     */
    private int[][] step5(int[][] costMatrix){

        return costMatrix;
    }

    public int[][] optimalAssignment(){
        //should check is the matrix is already in optimal assignment first before starting algorithm?

        int[][] optimalAssignmentMatrix;

        print2D(costMatrix);

        optimalAssignmentMatrix = step1(costMatrix);
        print2D(optimalAssignmentMatrix); //row reduction stage

        optimalAssignmentMatrix = step2(optimalAssignmentMatrix);
        print2D(optimalAssignmentMatrix); //column reduction stage

        /**
         *  First check for Optimal when column reduction is done
         *  If not optimal, run the while loop until optimal is found
         * 
         *      While loop
         *          shift the zeros using step 4
         *          Test for optimal using step 3
         *          Stop when optimal assignment is found -> true
         *          
         */
        boolean testforOptimal = step3(optimalAssignmentMatrix);

        while(!testforOptimal){
            optimalAssignmentMatrix = step4(optimalAssignmentMatrix);
            print2D(optimalAssignmentMatrix);
            testforOptimal = step3(optimalAssignmentMatrix);
        }

        optimalAssignmentMatrix = step5(optimalAssignmentMatrix);
        print2D(optimalAssignmentMatrix);

        return optimalAssignmentMatrix;
    }


    /**
     * Allows you to find the smallest number within the costMatrix
     * Used in step 4
     * @param numbers
     * @return
     */
    private int getMinValue(int[][] array) {
        int minValue = array[0][0];
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array[j].length; i++) {
                if (array[j][i] < minValue ) {
                    minValue = array[j][i];
                }
            }
        }
        return minValue ;
    }

    /**
     * Print the 2D array
     * @param array
     */
    private void print2D(int[][] array){ 
        // Loop through all rows 
        for (int i = 0; i < array.length; i++) 
  
            // Loop through all elements of current row 
            for (int j = 0; j < array[i].length; j++) 
                System.out.print(array[i][j] + " "); 
    } 


}