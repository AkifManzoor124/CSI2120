//Name: Akif Manzoor
//Student Number: 8298086

package main

import (
	"fmt"
	"math/rand"
	"time"
)

//Question 1
//Functions, Arrays, and Slices

//Applied the function operation to each element of the slice
//reutrn the sum of the return values of operation function

//a) square function
//b) times2 function
//c) replaces each value in slice to random between 0 to 10 but adds original values

func applyOperation(operation string, slice []int) (result int) {

	switch operation {
	case "square":
		for i := range slice {
			//slice[i] = math.Pow(slice[i], 2)
			fmt.Println("Not sure why this won't work %v", i)
		}

	case "times2":
		for i := range slice {
			slice[i] = slice[i] * 2
		}
	default:
		for i := range slice {
			randNum := rand.Intn(11)
			slice[i] = randNum
		}
	}
	return
}

//Question 2
//Errors, Panics and Recovery

type Point struct {
	x int
	y int
}

func areaT(a Point, b Point, c Point) (area float32, result bool) {
	//Error code if the following conditions occur
	//If the vertices are not in the correct order and the area is negative
	//If the three points are colinear -> The answer will be zero
	//function should panic if any two vertices are identical

	first := b.x - a.x
	second := c.y - a.y
	third := c.x - a.x
	fourth := b.y - a.y

	determinant := float32((1 / 2) * (first*second - third*fourth))

	//If the three points are colinear -> The answer will be zero
	if determinant == 0 {
		return determinant, false
		//If the vertices are not in the correct order and the area is negative
	} else if determinant < 0 {
		return determinant, false
	} else {
		return determinant, true
	}
}

//Question 3
//Structures, Methods, Interfaces, Channels and Go Routines

type Furniture struct {
	Piece          string
	Brand          string
	ProductionDate time.Time
}
type Car struct {
	Make          string
	Name          string
	InServiceDate time.Time
}
type Painting struct {
	Title  string
	Artist string
	Year   time.Time
}
type AuctionState struct {
	Assessed float32
	HighBid  float32
	//Bidder   HighBidder
	Sold bool
}

type AuctionItem interface {
	getDescription() string
	getAssessedValue() float32
	getHighestBid() (float32, Bidder)
	setHighestBid(float32, Bidder) bool
	hasSold() bool
	setSold(bool)
	copy() AuctionItem
}

type Bid struct {
	name   string
	Amount float32
	//chan<- AuctionItem that accepts Response from Auction house
}
type Bidder struct {
	Name  string
	Money float32
}

func main() {
	fmt.Println("Which Question would you like to evaluate?")
	fmt.Println("Question 1 = 1, Question 2 = 2, Question 3 = 3")

	//not sure as to why the scan doesn't work
	//only goes to the first question
	var question int
	question, _ = fmt.Scan(&question)

	if question == 1 {
		fmt.Println("Start and end Position?")
		fmt.Println("Operation: 1 = square, 2 = times2, 3 = scramble")

		operation := "square"

		array := [9]int{1, 2, 3, 4, 5, 6, 7, 8, 9}
		var slice []int = array[1:4]

		applyOperation(operation, slice)

	} else if question == 2 {
		result1, val1 := areaT(Point{0, 0}, Point{5, 0}, Point{3, 3})
		result2, val2 := areaT(Point{0, 0}, Point{3, 3}, Point{5, 0})
		result3, val3 := areaT(Point{0, 0}, Point{5, 0}, Point{7, 0})
		result4, val4 := areaT(Point{0, 0}, Point{3, 3}, Point{3, 3})

		fmt.Println("Area of {0,0} {5,0} {3,3} = %v %v", result1, val1)
		fmt.Println("Area of {0,0} {3,3} {5,0} = %v %v", result2, val2)
		fmt.Println("Area of {0,0} {5,0} {7,0} = %v %v", result3, val3)
		fmt.Println("Area of {0,0} {3,3} {3,3} = %v %v", result4, val4)
	} else {
		//question 3

	}
}
