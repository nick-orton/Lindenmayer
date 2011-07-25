(ns lindenmayer.test.core
  (:use [lindenmayer.core])
  (:use [clojure.test]))

(def undertest (l-sys {:a [:a :b :c] :b [:b :b] :c [:c :b :a]}))

(deftest expand
  (is (= [:a :b :c] (beta-subs undertest [:a] ))))
