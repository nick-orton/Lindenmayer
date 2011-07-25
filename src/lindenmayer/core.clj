(ns lindenmayer.core)

(defprotocol Grammar
  (expand [this seed])
  )

(defn l-sys
  [rules]
  (reify Grammar
    (expand [this seed] (flatten (map rules seed))))
  )
