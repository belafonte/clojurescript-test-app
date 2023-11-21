(ns frontend.app
  (:require [reagent.core :as r]
            ["react-dom/client" :refer [createRoot]]))

(defonce root (createRoot (js/document.getElementById "app")))

(defn simple-component []
  [:div
   [:p "I am a component!"]
   [:p.someclass
    "I have " [:strong "bold"]
    [:span {:style {:color "red"}} " and red "] "text."]])

(defn app-view []
  [:div "Hello, World!"]
  [simple-component])
  

(defn ^:dev/after-load render []
  (println "render root")
  (.render root (r/as-element [app-view])))

(defn ^:export init []
  (render))
