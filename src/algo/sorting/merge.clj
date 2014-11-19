(ns algo.sorting.merge
  (:require [clojure.math.numeric-tower :refer (floor)])
  )

(defn- cut [l]
  (-> l
      count
      (/ 2)
      floor
      (split-at l)))

(defn my-merge [left right]
  (loop [l (seq left) r (seq right) new-list []]
    (println l r new-list)
    (if (and (not ( empty? l)) (not (empty? r)))
      (if (>= (first l) (first r))
        (recur l (rest r) (conj new-list (first r)))
        (recur (rest l) r (conj new-list (first l))) )
      (if (and (empty? l) (not (empty? r)))
        (recur l (rest r) (conj new-list (first r)))
        (if (and (empty? r) (not (empty? l)))
          (recur (rest l) r (conj new-list (first l)))
          new-list)))))

(defn merge-sort [unsorted]
  (println unsorted)
  (if (< 1 (count unsorted))
    (let [left (merge-sort (vec (first (cut unsorted))))
          right (merge-sort (vec (second (cut unsorted))))]
      (my-merge left right))
    unsorted)
  )
