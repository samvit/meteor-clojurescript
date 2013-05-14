goog.provide('cljs.nodejs');
goog.require('cljs.core');
cljs.nodejs.require = require;
cljs.nodejs.process = process;
cljs.core.string_print = cljs.nodejs.require.call(null,"sys").print;
