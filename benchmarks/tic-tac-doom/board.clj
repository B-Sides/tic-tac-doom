(require '[criterium.core :as bench] '[tic-tac-doom.board :as core])

(def empty-board [[:e :e :e] 
                  [:e :e :e] 
                  [:e :e :e]])

(def diag-x [[:x :o :e]
             [:o :x :o]
             [:e :o :x]])

(defn benchmark [title fn]
  (println title)
  (println "\nWith an empty board")
  (bench/quick-bench (fn empty-board))
  (println "\nWith diagonal win for X")
  (bench/quick-bench (fn diag-x)))

(benchmark "Benchmark for tic-tac-doom.core/analyze" core/analyze)
