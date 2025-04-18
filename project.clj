(defproject my-project "0.1.0-SNAPSHOT"
  :description "A simple project"
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [ring/ring-core "1.9.6"]
                 [ring/ring-jetty-adapter "1.9.6"]]

  :plugins [[lein-ring "0.12.6"]]

  :ring {:handler my-project.core/handler
         :war-name "my-project.war"})
Í