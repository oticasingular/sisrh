(defproject sisrh "0.1.0-SNAPSHOT"
  :description "Aplicação de exemplo"
  :dependencies [
    ;; Dependências do Clojure
    [org.clojure/clojure "1.11.0"]  ;; Versão mais recente do Clojure

    ;; Dependências do Maven convertidas para Leiningen
    [com.sun.xml.ws/jaxws-rt "2.3.5"]      ;; JAX-WS
    [javax.servlet/javax.servlet-api "3.0.1" :scope "provided"] ;; Servlet API
    [org.hsqldb/hsqldb "2.6.0"]            ;; Banco HSQLDB

    ;; Dependências do Ring para o servidor web
    [ring/ring-core "1.9.3"]               ;; Core do Ring
    [ring/ring-jetty-adapter "1.9.3"]      ;; Adapter para o servidor Jetty
    [compojure "1.6.2"]                    ;; Framework de rotas para Clojure
    [hiccup "1.0.5"]                       ;; Gerador de HTML
    [org.clojure/tools.logging "1.2.3"]    ;; Para logging
  ]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler sisrh.servlet.app  ;; ou outro namespace válido
         :war-name "sisrh.war"}
)
