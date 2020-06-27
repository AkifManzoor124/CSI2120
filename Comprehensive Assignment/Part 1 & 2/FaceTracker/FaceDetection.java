package FaceTracker;

public class FaceDetection {
    
    String file;

    public FaceDetection(String file){
        this.file = file;
    }

    public int[][] convertCSVto2DArray(){
        int[][] array = {};
        return array;
    }

    //placeholders
    //did not have enough time to convert from csv to matrix
    public int[][] getMatrix(){
        
        if(file == "file1"){
            int[][] frame1 = {
                {100,80,41,52},
                {300,392,32,45},
                {405,160,28,31}
            };
            return frame1;
        }else{
            int[][] frame2 = {
                {300,120,43,51},
                {312,236,28,40},
                {395,241,25,30}
            };
            return frame2;
        }
    }
}