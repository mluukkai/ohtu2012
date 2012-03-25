package main

import (
	"fmt"
)

type Player struct {
	name    string
	team    string
	goals   int
	assists int
}

func NewPlayer(name string, team string, goals int, assists int) *Player {
	return &Player{name: name, team: team, goals: goals, assists: assists}
}

func (p *Player) Assists() int {
	return p.assists
}

func (p *Player) SetAssists(assists int) {
	p.assists = assists
}

func (p *Player) Goals() int {
	return p.goals
}

func (p *Player) SetGoals(goals int) {
	p.goals = goals
}

func (p *Player) Name() string {
	return p.name
}

func (p *Player) SetName(name string) {
	p.name = name
}

func (p *Player) Team() string {
	return p.team
}

func (p *Player) SetTeam(team string) {
	p.team = team
}

func (p *Player) Points() int {
	return p.goals + p.assists
}

func (p *Player) String() string {
	return fmt.Sprintf("%-20s %s %2d + %2d = %d", p.name, p.team, p.goals, p.assists, p.Points())
}

func (p *Player) Compare(p2 *Player) int {
	return p.Points() - p2.Points()
}

// Satisfy sort interface for []*Player
type Playerslice []*Player

func (players Playerslice) Len() int {
	return len(players)
}

func (players Playerslice) Less(i, j int) bool {
	if players[i].Compare(players[j]) < 0 {
		return false
	}
	return true
}

func (players Playerslice) Swap(i, j int) {
	players[i], players[j] = players[j], players[i]
}
