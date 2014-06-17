(ns anagrams-clojure.core)
(:gen-class :main true)

;; Things I learned.
;; group-by rather than coding group-by
;; Use reader rather than slurp for scalability
;; Can use line-seq instead of split
;; java.io/reader works with both http and file URIs
;; To get command line app, include gen-clss in the ns declaration
;; main has signature
;;(defn -main[& args]


(comment 
  (group-by sort ["pan" "nap" "bind"])
  ; -->
  {(\a \n \p) ["pan" "nap"], (\b \d \i \n) ["bind"]}
  )


(defn anagrams
  "Given a (lazy list of words, return a list of sets. Each set will contain
  words that are anagrams of each other.  "
  [words]
  (map set
       (filter #(> (count %) 1)
               (vals 
                 (group-by sort words) 
                 ))))


(def default-dict-URI
  "http://www.puzzlers.org/pub/wordlists/unixdict.txt"
  ;"/usr/share/dict/american-english"
  )

(defn build-dict[my-URI]
  "Return lazy list of the alpha words in the URI"
  (filter #(re-matches #"[a-z]+" %)
          (->
            my-URI
            clojure.java.io/reader
            line-seq 
            ))) 

(comment
  "Tests are here"
  (println
    (anagrams ["a" "at" "tar"])
    )
  (println
    (anagrams ["crooner" "coroner" "croon"])
    )
  (println (take 20 (anagrams (build-dict default-dict-URI))))
  (println (take 30 (-main)))
  (println (take 10 (-main "/usr/share/dict/american-english")))
  )


(defn -main[& args]
  "Given a file or http URI, generate lists of anagrams to stdout"
  (let [my-dict-URI 
        (if (empty? args)
          (do (println "Using " default-dict-URI)
              default-dict-URI)
          (first args))]
    (println (anagrams (build-dict my-dict-URI)))))
