Meteor-ClojureScript
=======

Meteor-ClojureScript is an attempt to write meteor applications in idiomatic clojurescript.

Install
-------

You need Meteor and Lein
    
Usage
-----

I'll be writing detailed instructions once stuff works nicely. For now, if you know what you are doing, you can compile the clojurescript:

    lein cljsbuild

For faster iteration: I recommend keeping a terminal open and running

    lein cljsbuild auto

Remove the nodejs shebang with

    sed "1 d" -i server/main.js > server/temp.js; mv server/temp.js server/main.js

Yes indeed, that is pretty hacky

And run the application with

    meteor run

License
----
MIT Licensed
