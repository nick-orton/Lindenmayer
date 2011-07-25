(ns lindenmayer.test.core
  (:use [lindenmayer.core])
  (:use [clojure.test]))

(def rules {:a [:a :b :c]
            :b [:b :b] 
            :c [:c :b :a]})

(def undertest (l-sys rules ))

(deftest expand
  (is (= [:a :b :c] (beta-subs undertest [:a] ))))
