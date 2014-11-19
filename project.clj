(defproject clojure.algo "0.1.0-SNAPSHOT"
  :description "Playing Around with Sorting and Other Datastructures"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/math.numeric-tower "0.0.4"] ]
  :plugins [[lein-expectations "0.0.7"] ]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.7"]
                                  [expectations "2.0.9"]]
                   :source-paths ["dev"]}})
