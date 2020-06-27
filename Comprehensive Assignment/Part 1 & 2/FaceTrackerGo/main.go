package main

import(
	"fmt"
	"encoding/csv"
	"log"
	"os"
)

func main(){

	string csvfile := readCsvFile()

	int[][] costMatrix := convertToCostMatrix("string")

	int[][] optimalMatrix := getOptimalMatrix(costMatrix)

	writeCsvFile(optimalMatrix)
	
}

func readCsvFile(fileName string) {
    f, err := os.Open(fileName)
    if err != nil {
        log.Fatal("Unable to read input file " + fileName, err)
    }
    defer f.Close()

    csvReader := csv.NewReader(f)
    record, err := csvReader.ReadAll()
    if err != nil {
        log.Fatal("Unable to parse file as CSV for " + fileName, err)
    }
	return record
}

func writeCsvFile(matrix){
	csvfile, err := os.Create("test.csv")
 
	if err != nil {
		log.Fatalf("failed creating file: %s", err)
	}
 
	csvwriter := csv.NewWriter(csvfile)
 
	for _, row := range rows {
		_ = csvwriter.Write(row)
	}
 
	csvwriter.Flush()
 
	csvfile.Close()
}


	