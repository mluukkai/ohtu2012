package main

import (
	"sort"
	"strings"
)

type Statistics struct {
	players []*Player
}

func NewStatistics(reader Reader) *Statistics {
	return &Statistics{players: reader.Players()}
}

func (s *Statistics) Search(name string) *Player {
	for _, player := range s.players {
		if strings.Contains(player.Name(), name) {
			return player
		}
	}
	return nil
}

func (s *Statistics) Team(teamName string) []*Player {
	playersOfTeam := make([]*Player, 0, 20)
	for _, player := range s.players {
		if player.Team() == teamName {
			playersOfTeam = append(playersOfTeam, player)
		}
	}
	return playersOfTeam
}

func (s *Statistics) TopScorers(howMany int) []*Player {
	sort.Sort(Playerslice(s.players))

	topScorers := make([]*Player, 0, howMany)
	var players []*Player

	if howMany > len(s.players) {
		players = s.players
	} else {
		players = s.players[:howMany]
	}
	for _, player := range players {
		topScorers = append(topScorers, player)
	}
	return topScorers
}
