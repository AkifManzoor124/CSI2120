package FaceTracker;

public class MatchingCost {
    
    //placeholder 
    //I can implement the hungarian Algorithm with this
    //substitute the costMatrix made by the program when I have time
    int[][] costMatrix = {
        {205,254,324},
        {269,159,183},
        {102,123,81}
    };

    public int[][] EuclideanDistance(int[][] matrix1, int[][] matrix2){

        int[][] centerArray1 = getCenterArray(matrix1);
        int[][] centerArray2 = getCenterArray(matrix2);

        

        return costMatrix;
    }

    public int[][] getCenterArray(int[][] matrix){
        int Cx;
        int Cy;
        int Wx;
        int Hx;
        
        //Don't know if this array can expand for more than 3x3 
        //first value holds X coordinate
        //second value holds Y coordinate
        int[][] centerArray = {
            {0,0},
            {0,0},
            {0,0}
        };
        
        //Find the center value for each face
        //calculate distance from center value to another center value
        for(int i = 0; i < matrix.length; i++){
            Cx = matrix[i][0];
            Cy = matrix[i][1];
            Wx = matrix[i][2];
            Hx = matrix[i][3];

            centerArray[i][0] = Cx + (Wx/2);
            centerArray[i][1] = Cy + (Hx/2);
        }

        return centerArray;
    }

    public int[][] method2(int[][] matrix1, int[][] matrix2){
        return costMatrix;
    }
}