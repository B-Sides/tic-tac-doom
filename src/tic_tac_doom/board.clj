(ns tic-tac-doom.board)

(defn check-solution [elements]
  (if (= (first elements) :e)
    nil
    (if (apply = elements) (first elements) nil)))

(defn columns [elements]
  (apply interleave elements))

(defn diagonals [elements]
  [(for [i (range (count elements))] [(nth (nth elements i) i)])
   (for [i (range (count elements))] [(nth (reverse (nth elements i)) i)])])

(defn possible-solutions [board]
  (let [size (count (first board))]
    (partition size (flatten (concat board (columns board) (diagonals board))))))

(defn analyze
  "Expects a game board represented as an seq of seq (rows). e.g. [[:x :y] [:x :y]]"
  [board]
  (some check-solution (possible-solutions board)))


