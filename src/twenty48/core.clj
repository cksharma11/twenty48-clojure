(ns twenty48.core)

(defn remove-zeroes [coll]
  (filter pos? coll))

(defn append-zeroes [size coll]
  (take size (concat coll (repeat 0))))

(defn move-left-row [row]
  (->> row
       (remove-zeroes)
       (partition-by identity)
       (mapcat (partial partition-all 2))
       (map (partial apply +))
       (append-zeroes (count row))))

(defn move-board-left [board]
  (map move-left-row board))

(defn reverse-board [board]
  (map reverse board))

(defn transpose [board]
  (apply map list board))

(defn move-board-right [board]
  (-> board
      reverse-board
      move-board-left
      reverse-board))

(defn move-board-up [board]
  (-> board
      transpose
      move-board-left
      transpose))

(defn move-board-down [board]
  (-> board
      transpose
      move-board-right
      transpose))