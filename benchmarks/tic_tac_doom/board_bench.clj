(ns tic-tac-doom.board-bench
  (:use perforate.core)
  (:require [tic-tac-doom.board :as core]))

(def empty-board [[:e :e :e] 
                  [:e :e :e] 
                  [:e :e :e]])

(def diag-x [[:x :o :e]
             [:o :x :o]
             [:e :o :x]])

(def no-win [[:x :o :e]
             [:x :o :e]
             [:o :e :x]])

(defgoal board-bench "Board Benchmark")

(defcase board-bench :empty-board []
  (core/analyze empty-board))

(defcase board-bench :x-diag-win []
  (core/analyze diag-x))

(defcase board-bench :no-winner []
  (core/analyze no-win))
