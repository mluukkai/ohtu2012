package main

import (
	"encoding/csv"
	"net/http"
	"strconv"
	"strings"
)

type PlayerReader struct {
	players []*Player
}

func NewPlayerReader(pageUrl string) (*PlayerReader, error) {
	resp, err := http.Get(pageUrl)
	if err != nil {
		return nil, err
	}
	defer resp.Body.Close()

	playerreader := &PlayerReader{players: make([]*Player, 0, 100)}

	reader := csv.NewReader(resp.Body)
	reader.Comma = ';'
	reader.FieldsPerRecord = 6

	var record []string
	for {
		record, err = reader.Read()
		if err != nil {
			if err.Error() == "EOF" {
				break
			} else if len(record) < 4 {
				continue
			}
		}
		goals, _ := strconv.Atoi(record[3])
		assists, _ := strconv.Atoi(record[4])
		playerreader.players = append(playerreader.players, NewPlayer(strings.TrimSpace(record[0]), record[1], goals, assists))
	}
	return playerreader, nil
}

func (pr *PlayerReader) Players() []*Player {
	return pr.players
}
