:plugins [[lein-ring "0.12.5"]]

:ring {:handler sisrh.servlet.app  ;; ou outro namespace válido
       :war-name "sisrh.war"}
