(ns tic-tac-doom.core)

(defn hello-world-handler [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hello, world!"})
