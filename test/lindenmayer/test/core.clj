(ns lindenmayer.test.core
  (:use [lindenmayer.core])
  (:use [clojure.test]))

(def rules {:a [:a :b :c]
            :b [:b :b] 
            :c [:c :b :a]})

(def undertest (l-sys rules ))

(deftest test-expand
  (is (= [:a :b :c ] (expand undertest [:a] )))
  (is (= [:a :b :c :b :b :c :b :a] (expand undertest (expand undertest [:a] )))))

(deftest test-expand-n
  (is (= [:a :b :c :b :b :c :b :a] (expand-n undertest [:a] 2))))
