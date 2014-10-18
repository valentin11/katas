(ns code-katas-3.core
  (:use [clojure.core.logic])
  (:require [clojure.core.logic.fd :as fd])
  (:refer-clojure :exclude [== inc reify]))


;;1)

(defn sumaro
  "Escriba una relacion sumar donde a mas b sea igual a c"
  [a b c]
  (fd/+ a b c))
     
;;2)
  (defn restaro
  "Escriba una relacion restar donde a menos b sea igual a c"
  [a b c]
   (fd/- a b c)
  )

;;3)
  (defn sumarlisto
  "Escriba una relacion sumarlisto donde la suma de todos los
   elementos de la lista lst sea igual al resultado en res"
  [res lst]
  (conde
    ((emptyo lst) (== res 0))
    ((fresh [x y z]
         (firsto lst x);x toma el primer elemento de la lista lst
         (fd/- res x z);z va a tomar el potencial valor de res - x.
         (resto lst y);y se convierte en el resto de la lista lst
         (sumarlisto z y)))));se llama recurvia con el valor "acumulado" z y el resto de la lista.
                             ;La relacion sumarlisto tiene que cumplir con tadas estas restricciones. 
    
;;4)
   (defn ultimoo
  "Escriba una relacion ultimoo, donde u sea el ultimo elemento de l

  Considere usar appendo
  http://clojure.github.io/core.logic/#clojure.core.logic/appendo"
  [l u]
  (fresh [x]
         (appendo x (vector u) l)))
;;5)
   (defn tmuo
  "Escriba una relacion tmuo donde tmul es una lista que contiene los
  mismos elementos que l, menos el ultimo.

  Considere usar appendo
  http://clojure.github.io/core.logic/#clojure.core.logic/appendo"
  [l tmul]
  (appendo [] tmul (butlast l))
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
   ((ultimoo l x));Que cumple con la relacion ultimoo.
   ((fresh [d]   
        (ultimoo l d)
        (memberro l d)))))

;;7)
   (defn listofnumbero
  "Escriba una relacion donde l sea una lista de numeros"
  [l]
    (conde
      ((fresh [z];Caso base, que l tenga un solo elemento y que este sea un numero. 
              (fd/in z (fd/interval 1 10))
              (appendo (list z) '() l)))
       ((fresh [x y]
              (fd/in x (fd/interval 1 10))
              (firsto l x)
              (resto l y)
              (listofnumbero y)))
)) 
;;8)
  
(defn remindero
  "Escriba una relacion donde r sea el remainder de dividir p entre q.
   Asumiendo que no se pasaran valores mayores a 1000 en p"
  [p q r]
  (fresh [x z]
         (fd/in x (fd/interval 1 1000))
         (!= q 0);El dividendo no puede ser 0.
         (fd/< r q);El resto debe estar ser menor que divisor (q)
         (fd/<= 0 r);El resto debe ser mayor o igual a cero.
         (fd/- p r z);Se crea una variable z que va a hacer la resta entre el dividendo(p) y el resto(r).
         (fd/quot z q x);x es el cociente que es igual a (p-r)/q
         ;Todas estas restricciones salen de la divicion. (p = qx +r).
  ))         
;9)

;(defn aux-prime?
;  [x n]
;  (cond
;  (= x n) true
;  (and (> n 1) (= 0 (rem x n))) false
;  :else (aux-prime? x (+ n 1))))
;
;(defn prime?
;  [x]
;  (aux-prime? x 1))

(defn my-aux-prime [q n]
  (conde
    ((== q n) s#) 
    ((fresh [x y]
            (remindero q n x)
            (!= 0 x);me aseguro que ningun multiplo de n va a hacer solucion.
            (fd/+ n 1 y)
            (my-aux-prime q y)))))

(defn my-prime?
 [x]
 (my-aux-prime x 2));El uno no se concidera un numero primo, ya que solo tiene un deivisior y es el mismo.
 
(defn primeo
  "Dadas las dos funciones anteriores para determinar si un numero es primo
   transformelas en una relacion. (Utilice la relacion remindero anterior)"
  [x]
  (my-prime? x))
