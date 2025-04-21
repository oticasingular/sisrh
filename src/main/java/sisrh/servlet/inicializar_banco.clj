(ns sisrh.servlet.inicializar-banco
  (:import [sisrh.servlet InicializarBancoServlet])
  (:require [ring.util.response :as response]))

(def servlet (InicializarBancoServlet.))

(defn inicializar-banco-handler [_]
  (.inicializarBancoViaClojure servlet)
  (response/response "Banco inicializado com sucesso via deploy"))
