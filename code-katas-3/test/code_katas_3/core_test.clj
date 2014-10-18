(ns code-katas-3.core-test
  (:require [clojure.test :refer :all]
            [code-katas-3.core :refer :all]
            [clojure.core.logic :as l])
  (:refer-clojure :exclude [== inc reify]))


(deftest sumaro-test
  (is (= (l/run* [q] (sumaro q 1 2)) '(1)))
  (is (= (l/run* [q] (sumaro 1 q 5)) '(4)))
  (is (= (l/run* [q] (sumaro 1 6 q)) '(7)))
  (is (= (l/run* [q] (sumaro 1 1 1)) '())))


(deftest restaro-test
  (is (= (l/run* [q] (restaro q 1 2)) '(3)))
  (is (= (l/run* [q] (restaro 1 q 5)) '(-4)))
  (is (= (l/run* [q] (restaro 1 6 q)) '(-5)))
  (is (= (l/run* [q] (restaro 1 1 1)) '())))


(deftest sumarorec-test
  (is (= (l/run* [q] (sumarlisto q [1 2])) '(3)))
  (is (= (l/run* [q] (sumarlisto 7 [1 2 q])) '(4))))

(deftest memberro-test
  (is (= (l/run 5 [q] (memberro :a q))
         '((:a) (_0 :a) (_0 _1 :a) (_0 _1 _2 :a) (_0 _1 _2 _3 :a)))))

(deftest ultimoo-test
 (is (= (l/run* [q] (ultimoo [1 2 3 4] q)) '(4)))
 (is (= (l/run* [q] (ultimoo [1 2 3 q] 4)) '(4)))
 (is (= (l/run* [q] (ultimoo [q 2 3 4] 4)) '(_0)))
 (is (= (l/run* [q] (ultimoo [q 2 3 5] 4)) '()))
 )

(deftest tmuo-test
  (is (= (l/run* [q] (tmuo [1 2 3 4] q)) '((1 2 3))))
  (is (= (l/run* [q] (tmuo [1 2 3 4] [1 2 3])) '(_0)))
  (is (= (l/run* [q] (tmuo [1 2 3 q] [1 2 3])) '(_0)))
  (is (= (l/run* [q] (tmuo [1 2 q 5] [1 2 3])) '(3)))
  )

(deftest listofnumbero-test
  (is (= (l/run 3 [q] (listofnumbero [])) '()))
  (is (= (l/run* [q] (listofnumbero [1 2 q])) '(1 2 3 4 5 6 7 8 9 10)))
  (is (= (l/run 3 [q] (listofnumbero q)) '((1) (2) (3))))
  (is (= (l/run 10 [q] (listofnumbero q)) '((1) (2) (3) (4) (5) (1 1) (6) (7) (2 1) (8))));Este test se cambio, ya que el resultado
                                                                                          ;varia segun la implementacion.
)

(deftest remindero-test
 (is (= (l/run 3 [q] (remindero 10 2 q)) '(0)))
 (is (= (l/run 3 [q] (remindero q 2 0)) '(2 4 6)))
 (is (= (l/run 1 [q] (remindero 10 q 2)) '(4)))
 (is (= (l/run 1 [q] (remindero 10 q 5)) '())))

(deftest primeo-test
  (is (= (l/run 11 [q] (primeo q)) '(2 3 5 7 11 13 17 19 23 29 31))) ;El uno no se considera un numero primo.
  (is (= (l/run 25 [q] (primeo q)) '(2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97))));Los primeros primos menores que 100, segun wikipedia. (Son 25 primos)