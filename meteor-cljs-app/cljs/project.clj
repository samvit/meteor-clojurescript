(defproject proj "1.0.0"
  :dependencies [[org.clojure/clojure "1.4.0"]]
  :plugins [[lein-cljsbuild "0.2.7"]]
  :cljsbuild {:builds [{:source-path "client"
                        :compiler {:output-to "../client/main.js"
                                   ;TODO: :advanced untested:
                                   :optimizations :whitespace
                                   :pretty-print true}}
                       {:source-path "server"
                        :compiler {:output-to "../server/main.js"
                                   :target :nodejs
                                   :optimizations :simple
                                   :pretty-print true}}]})
