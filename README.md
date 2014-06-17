## anagrams_clojure

Find anagrams using Clojure

### Usage

git clone https://github.com/rothfield/anagrams-clojure
cd anagrams-clojure
lein run 

If not passed a URI uses "http://www.puzzlers.org/pub/wordlists/unixdict.txt"
URI can be http or file

### Things I learned.
 Use group-by rather than coding group-by functionality yourself!

 Use reader rather than slurp for scalability

 Can use line-seq instead of split

 java.io/reader works with both http and file URIs

 To get command line app, include gen-class in the ns declaration

 main has signature
 ;;(defn -main[& args] body)


  (group-by sort ["pan" "nap" "bind"])
  ; -->
  {(\a \n \p) ["pan" "nap"], (\b \d \i \n) ["bind"]}
  )

