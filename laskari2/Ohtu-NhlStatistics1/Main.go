package main

import (
	"fmt"
)

func main() {
	stats, _ := NewStatistics()
	fmt.Println("Philadelphia Flyers")
	for _, player := range stats.Team("PHI") {
		fmt.Println(player)
	}
	fmt.Println()
	fmt.Println("Top scorers")
	for _, player := range stats.TopScorers(10) {
		fmt.Println(player)
	}

}
