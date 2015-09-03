(ns forms-test.core
    (:require [reagent.core :as reagent :refer [atom]]))

(def num-form
  [:input {:field :numeric
           :id :number-field}])

(defn aview []
  (let [val (atom {})]
    (fn []
      [:div
       [:p "value:" (str @val)]
       [bind-fields num-form val]])))

(defn home-page []
  [:div [:h2 "numeric test"]
   [aview]])

(defn mount-root []
  (reagent/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (hook-browser-navigation!)
  (mount-root))
