(ns primes)

(defn prime? [num]
  (loop [v (range 2 (+ num 1))
         continue-searching? true]
    (if (or (= num (first v)) (not continue-searching?))
      continue-searching?
      (recur (rest v)
             (if (= 0 (rem num (first v)))
               false
               true)))))

(defn get-primes [maxnum]
  (loop [iv (range 2 maxnum)
         ov [1]]
    (if (empty? iv)
      ov
      (recur (rest iv)
             (if (prime? (first iv))
               (conj ov (first iv))
               ov)))))

(get-primes 100000)
