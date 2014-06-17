# anagrams_clojure

Find anagrams using Clojure

## Command Line Usage

lein run <URI>

If not passed a URI uses "http://www.puzzlers.org/pub/wordlists/unixdict.txt"

## Things I learned.
 Use group-by rather than coding group-by functionality yourself!
 Use reader rather than slurp for scalability
 Can use line-seq instead of split
 java.io/reader works with both http and file uris
 To get command line app, include gen-clss in the ns declaration
 main has signature
 ;;(defn -main[& args] body)


  (group-by sort ["pan" "nap" "bind"])
  ; -->
  {(\a \n \p) ["pan" "nap"], (\b \d \i \n) ["bind"]}
  )

