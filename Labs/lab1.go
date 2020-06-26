package main

import(
	"fmt"
	"math"
)

//Create a function which
//Parameters: float variable
//Returns: Two integer values
//One integer is the floor and the other is the ceiling
func exer1(x float64) (y,z int){
	y = int(math.Floor(x))
	z = int(math.Ceil(x))
	return y,z
}


func main(){
	//Exercise 1
	x,y := exer1(4.2)
	fmt.Println(x,y)

	//Exercise 2
	lineWidth := 5
	symb := "x"
	lineSymb := symb
	formatStr := fmt.Sprintf("%%%ds\n", lineWidth)
	fmt.Printf(formatStr, lineSymb)
}