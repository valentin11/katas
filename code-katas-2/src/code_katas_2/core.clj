(ns code-katas-2.core)


(defn unpartial
  "Escribir una funcion que acepte una funcion parcial con cantidad de argumentos desconocida,
   retornar una funcion equivalente de n argumentos"
  [f]
  ;(fn [& arg] (apply f arg))
  )


(defn search
  "Dado un numero cualquiera de secuencias, cada una ya ordenada de menor a mayor, encontrar el numero
   mas chico que aparezca en todas las secuencias, las secuencias pueden ser infinitas."
  [& seqs]
  (if (= (count seqs) 1)
    (first (first seqs));Devuelve el primer elemento.
    (first(clojure.set/intersection (map (fn [v](lazy-seq (set v))) seqs)));Pasarle los elementos dentro de una lista, NO la lista!
  )
  ;(map (fn [v](set v)) seqs);Paso los vectores a set.
)


(defn intercalar
  "Escriba una funcion que tome un predicado de 2 argumentos, un valor y una coleccion, y
   retorne una nueva coleccion donde el valor es insertado intercalado cada dos argumentos
   que cumplan el predicado"
  [predicado valor secuencia]
  (loop [p predicado v valor s secuencia l []]
    (if (or (= (count s) 0) (= (count s) 1));Asumo que para poner un valor necesito almenos dos elementos en la secuencia. 
       (conj l (first s))
       (recur p v (rest s) (if (p (first s) (second s))
                             (conj (conj l (first s)) valor)
                             (conj l (first s))
                            ));Lo pongo acá, porque fue la unica forma que pude hacer que vaya variando el vector l.
     )
   )
)


(defn tartamudeo
  "Escriba una funcion que retorne una secuencia lazy que comprima el tartamudeo de una secuencia de numeros.
   Comprimir el tartamudeo se refiere a que [1 1 1] se exprese como [3 1] y a su vez [3 1] se exprese como [1 3 1 1].

   La funcion debe aceptar una secuencia inicial de numeros, y devolver una secuencia infinita de compresiones, donde
   cada nuevo elemento es el elemento anterior comprimido."
  [secuencia]
  )


