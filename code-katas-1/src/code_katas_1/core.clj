(ns code-katas-1.core)
(defn foo [v] (print "holaMundo"))

(defn filter-odd
  "Escribir una funcion que retorne solamente los numeros impares de
   una secuencia"
  [s]
  (def length (count s))
  (def t (seq s));Creo un lista con el elemteno de entrada, para no tener excepciones.
  (def list '())
  (dotimes [loops length]
    (def number (nth t loops))
    (if (not (== (mod number 2) 0))(def list (conj list number)));El numero es impar si el resto de la divicion /2 es distinto de cero.
  )
  (reverse list)
  ;Esta funcion la hice asi porque supuse que no se podia usar filter-odd?
 )
(defn nil-key
  "Escribir una funcion que dada una clave y un mapa, devuelva true, solamente si el mapa
   contiene una entrada con esa clave, y su valor es nil"
  [k m]
  (eval (and (contains? m k) (= (get m k) nil)))
)


(defn range
  "Escribir una funcion que cree una lista de enteros en un rango dado.
   Restricciones: range"
  [start end]
  (def list (conj '() start));Defino la lista vacia con el valor inicial.
  (def aux start)
  (def loops (- end start))
  (while(eval (not ( == loops (count list))))
    (def aux (inc aux))
    (def list (conj list aux))
  )
  (reverse list);Invertir la lista porque la funcion conj inserta el incremento al principio.
 )

(defn compress-sequence
  "Escribir una funcion que elimine los duplicados consecutivos
   de una secuencia"
  [s]
  (def output-list (conj '() (nth s 0)))
  (dotimes [loops (- (count s) 1)]
    (def truth (not (= (nth s (+ loops 1)) (nth s loops))));No son iguales.
    (if truth (def output-list (conj output-list (nth s (+ loops 1)))))
  )
  (reverse output-list)
)

(defn max-value
  "Escribir una funcion que reciba un numero variable de parametros
   y retorne el que tenga el valor mayor
   Restricciones: max y max-key"
  [& args]
  (nth (sort args) (- (count (sort args)) 1));Ordeno la lista de menor a manor y tomo el ultimo elemtento de esta.
)

(defn split-two
  "Escribir una funcion que parta una secuencia en dos partes
   Restricciones: split-at"
  [length s]
  (def first-part [])
  (def second-part [])
  (def aux length)
  (dotimes [loops length]
    (def first-part (conj first-part (nth s loops)))
  )
  (while (eval(not(== aux (count s))))
    (def second-part (conj second-part (nth s aux)))
    (def aux (inc aux))
  )
  (eval [(eval first-part) (eval second-part)])
  )

(defn inter-two
  "Escribir una funcion que reciba dos secuencias y retorne el primero de cada una,
   luego el segundo de cada una, luego el tercero, etc.
   Restricciones: interleave"
  [s1 s2]
  (def list '())
  (dotimes [loops (min (count s1) (count s2))]
    (def list (conj list (nth s1 loops)))
    (def list (conj list (nth s2 loops)))
  )
  (reverse list)
)

(defn retrieve-caps
  "Escribir una funcion que reciba un string y devuelva un nuevo string conteniendo
   solamente las mayusculas."
  [text]
  (def upperCaps (filter #(java.lang.Character/isUpperCase %) text))
  (if (not (empty? upperCaps));Si no esta vacia.
    (reduce(fn [a b](str a "" b)) upperCaps);Concateno la lista que contiene las mayusculas ej:("\A\B")
    (reverse '());
  )
)

(defn find-truth
  "Escribir una funcion que tome un numero variable de booleans, y devuelva true
   solamente si alguno de los parametros son true, pero no todos son true. En otro
   caso debera retornar false"
  [& xs]
(def vect (into [] xs));Creo un vector con los elementos que la lista de entrada.
(eval (and (not-every? true? vect)(not (not-any? true? vect))));La primera parte del and chequea que no todos sean true en el vector.
                                                               ;La segunda parte del and chequea que haya almenos un true en el vector.  
)
(defn zip-map
  "Escribir una funcion que reciba un vector de claves y un vector de valores, y
   construya un mapa a partir de ellos.
   Restricciones: zipmap"
  [k v]
  (def map {});creo un mapa vacio.
  (def aux (- (min (count k) (count v)) 1));Para que no se vaya de rango, le resto 1.
  (dotimes [loops (min (count k) (count v))]
    (def map (assoc map (nth k (- aux loops)) (nth v (- aux loops))))
  )
  (eval map)
 )
