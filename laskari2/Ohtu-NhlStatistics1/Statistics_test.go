package main

import "testing"

type ReaderStub struct {
	players []*Player
}

var stub *ReaderStub
var stats *Statistics

func init() {
	stub = &ReaderStub{players: make([]*Player, 0, 5)}
	stub.players = append(stub.players, NewPlayer("Semenko", "EDM", 4, 12))
	stub.players = append(stub.players, NewPlayer("Lemieux", "PIT", 45, 54))
	stub.players = append(stub.players, NewPlayer("Kurri", "EDM", 37, 53))
	stub.players = append(stub.players, NewPlayer("Yzerman", "DET", 42, 56))
	stub.players = append(stub.players, NewPlayer("Gretzky", "EDM", 35, 89))
	stats = NewStatistics(stub)
}

func (rs *ReaderStub) Players() []*Player {
	return rs.players
}

func TestSearch(t *testing.T) {
	player := stats.Search("Kur")
	if player == nil || player.Name() != "Kurri" || player.Goals() != 37 {
		t.Error("Oikeaa pelaajaa ei löytynyt")
	}
}

func TestSearchNotFound(t *testing.T) {
	player := stats.Search("Lapio")
	if player != nil {
		t.Error("Löytyi mukamas pelaaja")
	}
}

func TestTeam(t *testing.T) {
	players := stats.Team("EDM")
	if len(players) != 3 {
		t.Error("Löytyi väärä määrä väkeä")
	}
	players = stats.Team("DET")
	if len(players) != 1 || players[0].Name() != "Yzerman" {
		t.Error("Löytyi väärä henkilö")
	}
	players = stats.Team("PEN")
	if len(players) != 0 {
		t.Error("Löytyi väärä joukkue")
	}
}

func TestTopScorers(t *testing.T) {
	scorers := stats.TopScorers(1000)
	if len(scorers) != 5 {
		t.Error("Yritetään etsiä liian montaa maalintekijää")
	}
	for i := 1; i < len(scorers); i++ {
		if scorers[i].Points() > scorers[i-1].Points() {
			t.Error("Pistemiehet väärässä järjestyksessä")
		}
	}
}

func TestSingleTopScorer(t *testing.T) {
	scorers := stats.TopScorers(1)
	if len(scorers) != 1 {
		t.Error("Väärä määrä väkeä")
	}
	if scorers[0].Name() != "Gretzky" {
		t.Error("Väärä mies kärjessä")
	}
}
