(ns lindenmayer.core)

(defprotocol Grammar
  (expand [this seed])
  (expand-n [this seed n])
  )

(defn l-sys
  [rules]
  (reify Grammar
    (expand [this seed] (flatten (map rules seed)))
    (expand-n 
      [this seed n]
      (if (= n 1)
          (expand this seed)
          (expand-n this (expand this seed) (- n 1)) 
      ))
  ))
