package FaceTracker;

import java.io.File;
import java.io.IOException;

public class OptimalAssignment{

    /**
     * Function: main
     * Parameters: String[] args
     * Return: None
     * 
     * Input: Two csv files which contain the detections of faces within the frames
     */
    public static void main(String[] args){
        //Read and Hold Face Detection

        //the csv files which contain the data for face detection
        String file1 = args[1];
        String file2 = args[2];
        String option = args[3];

        /**
         * Face Detection
         */
        FaceDetection detection1 = new FaceDetection("file1");
        FaceDetection detection2 = new FaceDetection("file2");

        int[][] frame1 = detection1.getMatrix();
        int[][] frame2 = detection2.getMatrix();
        
        
        /**
         * Calculate MatchingCost
         * 
         * Take the two frames and create the cost matrix
         * User has the option to pick between two cost function
         */
        MatchingCost mc = new MatchingCost();

        int[][] costMatrix = (option == "ED") ? mc.EuclideanDistance(frame1, frame2) : mc.method2(frame1, frame2);

        

        /**
         * Hungarian Algorithm
         * We now perform the Hungarian Algorithm on the costMatrix and find the optimal Assignment
         */
        HungarianAlgorithm ha = new HungarianAlgorithm(costMatrix);

        int[][] optimalMatrix = ha.optimalAssignment();


        /**
         * Optimal Assignment
         * 
         * Here, we are required to print to a csv file -> tracker_java_n.csv
         */
        
        //Code adapted from: https://www.w3schools.com/java/java_files_create.asp
        try {
            File myObj = new File("tracker_java_n.csv");
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

        //Now we need to print the matrix to the csv file

    }
}