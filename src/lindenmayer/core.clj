(ns lindenmayer.core
  (use [clojure.set] ))


(defprotocol LindenmayerSystem
  (expand [this seed])
  (expand-n [this seed n])
  )

(defn- validate
  [rules]
  (let [ks (set (keys rules))
        vs (set (flatten (vals rules)))]
       (empty? (difference vs ks))))

(defn l-sys
  [rules]
  (if (not (validate rules))
      (throw (IllegalArgumentException.))
      (reify LindenmayerSystem
        (expand [this seed] (flatten (map rules seed)))
        (expand-n 
          [this seed n]
          (if (= n 1)
            (expand this seed)
            (expand-n this (expand this seed) (- n 1)))))))
