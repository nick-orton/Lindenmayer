(ns lindenmayer.core)

(defprotocol Grammar
  (beta-subs [this seed])
  )

(defn l-sys
  [rules]
  (reify Grammar
    (beta-subs [this seed] (flatten (map rules seed))))
  )
