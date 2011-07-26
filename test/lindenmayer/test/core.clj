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

(def badrules {:a [:a :b]})

(deftest test-validate
  (try (do (l-sys badrules)
         (is false "should have thrown exception"))
       (catch IllegalArgumentException _)))
