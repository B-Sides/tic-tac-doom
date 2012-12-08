(ns tic-tac-doom.board-test
  (:use [criterium.core] [midje.sweet] [tic-tac-doom.board :as tic-tac-doom]))

(def empty-board [[:e :e :e]
                  [:e :e :e]
                  [:e :e :e]])

(def vertical-x-win [[:x :e :o]
                     [:x :e :e]
                     [:x :e :o]])

(def horizontal-o-win [[:e :x :e]
                       [:o :o :o]
                       [:x :e :x]])

(def tie1 [[:x :e :o]
           [:x :x :e]
           [:o :x :o]])

(def diagonal-x-win [[:x :e :e]
                     [:o :x :e]
                     [:o :e :x]])

(def diagonal-o-win [[:x :e :o]
                     [:x :o :e]
                     [:o :e :x]])

(def tie2 [[:x :o :x]
           [:x :o :x]
           [:o :x :o]])

(fact "An empty board has no winner"
      (tic-tac-doom/analyze empty-board) => nil)

(fact "X wins with 3 Xs vertically"
      (tic-tac-doom/analyze vertical-x-win) => :x)

(fact "O wins with 3 Os horizontally"
      (tic-tac-doom/analyze horizontal-o-win) => :o)

(fact "Nobody wins if neither X or O has three in a row/column/diagonal"
      (tic-tac-doom/analyze tie1) => nil)

(fact "X wins with 3 Xs in a diagonal"
      (tic-tac-doom/analyze diagonal-x-win) => :x)

(fact "O wins with 3 Os in a diagonal"
      (tic-tac-doom/analyze diagonal-o-win) => :o)

(fact "Nobody wins if neither X or O has three in a row/column/diagonal"
      (tic-tac-doom/analyze tie2) => nil)

