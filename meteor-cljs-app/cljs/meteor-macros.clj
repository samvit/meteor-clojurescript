;;Credit: These are from http://undefined.re/tag/7

(ns meteor-macros)
;; This assumes that a jq/map->js & jq/clj->js exist
;; (from jayq).

;; enlive like syntax;
(defmacro template-set [& forms]
  (let [forms (partition 2 forms)]
    `(do
       ~@(for [[selectors fun] forms]
         `(set! (-> js/Template ~@(map #(symbol (str ".-" (name %))) selectors)) ~fun)))))

(defmacro defcollection [name]
  `(def ~name (js/Meteor.Collection. (str (quote ~name)))))

(defmacro insert [coll doc]
  `(.insert ~coll (jq/map->js ~doc)))

(defmacro find [coll selector & [options]]
  `(.find ~coll (jq/map->js ~selector) (jq/map->js ~options)))

;; ffetch as in find & fetch
(defmacro ffetch [coll selector & [options]]
  `(-> ~coll
     (.find (jq/map->js ~selector) (jq/map->js ~options))
     .fetch))

(defmacro findOne [coll selector & [options]]
  `(.findOne ~coll (jq/map->js ~selector) (jq/map->js ~options)))

(defmacro remove [coll selector]
  `(.remove ~coll (jq/map->js ~selector)))

(defmacro update [coll selector modifier & [options]]
  `(.update ~coll (jq/map->js ~selector) (jq/clj->js ~modifier) (jq/map->js ~options)))
