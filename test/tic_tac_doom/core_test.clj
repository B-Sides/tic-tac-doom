(ns tic-tac-doom.core-test
  (:use [midje.sweet] [tic-tac-doom.core :as tic-tac-doom]))

(fact "An empty board has no winner"
      (tic-tac-doom/analyze [[:e :e :e]
                             [:e :e :e]
                             [:e :e :e]]) => nil)

(fact "X wins with 3 Xs vertically"
      (tic-tac-doom/analyze [[:x :e :o]
                             [:x :e :e]
                             [:x :e :o]]) => :x)

(fact "O wins with 3 Os horizontally"
      (tic-tac-doom/analyze [[:e :x :e]
                             [:o :o :o]
                             [:x :e :x]]) => :o)

(fact "Nobody wins if neither X or O has three in a row/column/diagonal"
      (tic-tac-doom/analyze [[:x :e :o]
                             [:x :x :e]
                             [:o :x :o]]) => nil)

(fact "X wins with 3 Xs in a diagonal"
      (tic-tac-doom/analyze [[:x :e :e]
                             [:o :x :e]
                             [:o :e :x]]) => :x)

(fact "O wins with 3 Os in a diagonal"
      (tic-tac-doom/analyze [[:x :e :o]
                             [:x :o :e]
                             [:o :e :x]]) => :o)

(fact "Nobody wins if neither X or O has three in a row/column/diagonal"
      (tic-tac-doom/analyze [[:x :o :x]
                             [:x :o :x]
                             [:o :x :o]]) => nil)
