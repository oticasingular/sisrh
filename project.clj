(defproject sisrh "0.1.0-SNAPSHOT"
  :description "Aplicação de exemplo"
  :dependencies [
    [org.clojure/clojure "1.11.0"]

    [com.sun.xml.ws/jaxws-rt "2.3.5"]
    [javax.servlet/javax.servlet-api "3.0.1" :scope "provided"]
    [org.hsqldb/hsqldb "2.6.0"]

    [ring/ring-core "1.9.3"]
    [ring/ring-jetty-adapter "1.9.3"]
    [compojure "1.6.2"]
    [hiccup "1.0.5"]
    [org.clojure/tools.logging "1.2.3"]
  ]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler sisrh.servlet.app
         :war-name "sisrh.war"})
