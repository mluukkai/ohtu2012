package main

import (
	"fmt"
)

type Reader interface {
	Players() []*Player
}

func main() {
	reader, err := NewPlayerReader("http://nhlstatistics.herokuapp.com/players.txt")
	if err != nil {
		fmt.Println(err.Error())
		return
	}

	stats := NewStatistics(reader)
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
