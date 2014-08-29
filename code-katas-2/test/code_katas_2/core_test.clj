(ns code-katas-2.core-test
  (:require [clojure.test :refer :all]
            [code-katas-2.core :as k]))



(deftest unpartial
  (is (= 20 ((k/unpartial (fn [a]
                            (fn [b]
                              (fn [c]
                                 (fn [d]
                                   (+ a b c d)))))) 10 5 3 2)))

  (is (= 30 ((k/unpartial (fn [a]
                            (fn [b]
                              (fn [c]
                                 (fn [d]
                                   (* a b c d)))))) 15 2 1 1)))

  (is (= 5 ((k/unpartial (fn [a]
                           (fn [b]
                             (/ a b)))) 10 2))))

(deftest search
  (is (= 2 (k/search [2 9 40 90])))
  (is (= 7 (k/search [1 2 3 4 5 6 7 8 9] [0.5 3/2 7 19])))
  (is (= 42 (k/search (range) (range 0 100 7/6) [10 23 31 42 72 182])))
  (is (= 64 (k/search (map #(* % % %) (range))
                      (filter #(zero? (bit-and % (dec %))) (range))
                      (iterate inc 20)))))


(deftest intercalar
  (is (= '(2 :menor 6 :menor 9 4 3) (k/intercalar < :menor [2 6 9 4 3])))
  (is (= '(8) (k/intercalar > :mayor [8])))
  (is (empty? (k/intercalar > :mayor ())))
  (is (= [0 1 :igual 1 2 3 :igual 5 8 13 :igual 21]
         (take 12 (->> [0 1]
                       (iterate (fn [[a b]] [b (+ a b)]))
                       (map first)
                       (k/intercalar (fn [a b]
                                        (= (mod a 2) (mod b 2)))
                                      :igual))))))


(deftest tartamudeo
  (is (= [[1 1] [2 1] [1 2 1 1]] (take 3 (k/tartamudeo [1]))))
  (is (= [3 1 2 4] (first (k/tartamudeo [1 1 1 4 4]))))
  (is (= [1 1 1 3 2 1 3 2 1 1] (nth (k/tartamudeo [1]) 6)))
  (is (= 338 (count (nth (k/tartamudeo [3 2]) 15)))))
