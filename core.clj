(ns my-project.core
  (:require [ring.util.response :as response]))

(defn handler [request]
  ;; Essa função recebe uma requisição HTTP e retorna uma resposta
  (response/response "Hello from WAR!"))
