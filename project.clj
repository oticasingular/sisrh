(defproject sisrh "0.1.0"
  :description "Projeto SISRH com integração Java e Clojure"
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [javax.servlet/javax.servlet-api "3.0.1"]
                 [org.hsqldb/hsqldb "2.6.0"]
                 [com.sun.xml.ws/jaxws-rt "2.3.5"]
                 [ring/ring-core "1.9.3"]
                 [ring/ring-jetty-adapter "1.9.3"]
                 [compojure "1.6.2"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler sisrh.servlet.inicializar-banco/inicializar-banco-handler
         :war-name "sisrh.war"}
  :java-source-paths ["src/main/java"]
  :resource-paths ["src/main/resources"])
