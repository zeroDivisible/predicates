(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== n x)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? true? 
          (map (fn [x] (has-award? book x)) awards)))

(defn my-some [pred a-seq]
  (first (filter #(identity %) (map pred a-seq))))

(defn my-every? [pred a-seq]
  (= (count a-seq)
     (count (filter #(identity %)
     (map pred a-seq)))))

(defn prime? [n]
  (cond
    (or (= 1 n) (= 2 n)) true
    (= 0 (mod n 2)) false
    :else (let [r (range 3 (+ 1 (Math/sqrt n)))]
            (every? #(not= 0 (mod n %)) r))))
;^^
