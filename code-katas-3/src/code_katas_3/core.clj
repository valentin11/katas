(ns code-katas-3.core
  (:use [clojure.core.logic])
  (:require [clojure.core.logic.fd :as fd])
  (:refer-clojure :exclude [== inc reify]))


;;1)

(defn sumaro
  "Escriba una relacion sumar donde a mas b sea igual a c"
  [a b c]
  )

;;2)

(defn restaro
  "Escriba una relacion restar donde a menos b sea igual a c"
  [a b c]
  )

;;3)

(defn sumarlisto
  "Escriba una relacion sumarlisto donde la suma de todos los
   elementos de la lista lst sea igual al resultado en res"
  [res lst]
  )

;;4)

(defn ultimoo
  "Escriba una relacion ultimoo, donde u sea el ultimo elemento de l

  Considere usar appendo
  http://clojure.github.io/core.logic/#clojure.core.logic/appendo"
  [l u]
  )

;;5)

(defn tmuo
  "Escriba una relacion tmuo donde tmul es una lista que contiene los
  mismos elementos que el menos el ultimo.

  Considere usar appendo
  http://clojure.github.io/core.logic/#clojure.core.logic/appendo"
  [l tmul]
  )


;;6)

(defn memberro
  "Transforme la funcion memberro para que al ejecutar

   (l/run 5 [q] (memberro :a q))

   devuelva :a en la ultima posicion.

   Que problema le ve a esta alternativa?"
  [x l]
  (conde
   ((emptyo l) u#)
   ((firsto l x))
   ((fresh [d]
           (resto l d)
           (memberro x d)))))

;;7)

(defn listofnumbero
  "Escriba una relacion donde l sea una lista de numeros"
  [l]
  )

;;8)

(defn remindero
  "Escriba una relacion donde r sea el reminder de dividir p entre q.
   Asumiendo que no se pasaran valores mayores a 1000 en p"
  [p q r]
  )

;;9)

(defn aux-prime?
  [x n]
  (cond
   (= x n) true
   (and (> n 1) (= 0 (rem x n))) false
   :else (aux-prime? x (+ n 1))))

(defn prime?
  [x]
  (aux-prime? x 1))


(defn primeo
  "Dadas las dos funciones anteriores para determinar si un numero es primo
   transformelas en una relacion. (Utilice la relacion remindero anterior)"
  [x]
  )
