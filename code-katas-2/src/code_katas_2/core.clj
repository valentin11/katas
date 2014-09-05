(ns code-katas-2.core)


(defn unpartial
  "Escribir una funcion que acepte una funcion parcial con cantidad de argumentos desconocida,
   retornar una funcion equivalente de n argumentos"
  [f]
  (fn [& seqs] 
    (loop [f f seqs seqs]
      (if(not (fn? f))
        f
        (recur (f (first seqs)) (rest seqs)))))
)


(defn search
  "Dado un numero cualquiera de secuencias, cada una ya ordenada de menor a mayor, encontrar el numero
   mas chico que aparezca en todas las secuencias, las secuencias pueden ser infinitas."
  [& seqs]
  (if (not-any? false? (map (fn [a](= (first (sort (map first seqs))) (first a))) seqs));Si todos los cabezales son iguales.
    (first (first seqs))
    (recur (map (fn [v](if (= (first v) (first (sort (map first seqs)))) (rest v) v)) seqs));Llamo recursivamente quitando el menor elemento de la correspondiente lista.
  )
)


(defn intercalar
  "Escriba una funcion que tome un predicado de 2 argumentos, un valor y una coleccion, y
   retorne una nueva coleccion donde el valor es insertado intercalado cada dos argumentos
   que cumplan el predicado"
  [predicado valor secuencia]
   (lazy-seq 
     (if (empty? secuencia)
         secuencia
         (do
           (if(and (not= (second secuencia) nil)(predicado (first secuencia) (second secuencia)))
             (cons (first secuencia) (cons valor (intercalar predicado valor (rest secuencia))))
             (cons (first secuencia) (intercalar predicado valor (rest secuencia))))))))
(defn tartamudeo
  "Escriba una funcion que retorne una secuencia lazy que comprima el tartamudeo de una secuencia de numeros.
   Comprimir el tartamudeo se refiere a que [1 1 1] se exprese como [3 1] y a su vez [3 1] se exprese como [1 3 1 1].

   La funcion debe aceptar una secuencia inicial de numeros, y devolver una secuencia infinita de compresiones, donde
   cada nuevo elemento es el elemento anterior comprimido."
  [secuencia]
  
(defn compress [v] 
    (loop [v v s [] repetitions 1]
      (if (empty? v)
        s
        (recur (rest v) (if (not= (first v) (second v)) (conj (conj s repetitions) (first v)) s)(if (not= (first v) (second v)) 1 (inc repetitions))))))
(rest (iterate compress secuencia))

)



