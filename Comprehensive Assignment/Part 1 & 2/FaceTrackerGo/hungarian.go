package hungarian

func convertToCostMatrix(string csvfile){
	//placeholder
	//Reads the csvfile and converts the csv values to a 2D array
    costMatrix := int[][]{
        {205,254,324},
        {269,159,183},
        {102,123,81}
	};
	return costMatrix
}

func getOptimalMatrix(int[][] costMatrix){
	
	finished := make(chan bool)

	go step1()
	<- finished
	go step2()

	boolean testforOptimal := step3()

	for !testforOptimal{
		step4()
		testforOptimal := step3()
	} 

	step5()
	
	optimalMatrix := int[][]{
		{0,0,0},
		{0,0,0},
		{0,0,0}
	}
	return optimalMatrix
}

func step1(int[][] costMatrix){
	
}

func step2(int[][] costMatrix){

}

func step3(int[][] costMatrix){
	return true
}

func step4(int[][] costMatrix){

}

func step5(int[][] costMatrix){

}