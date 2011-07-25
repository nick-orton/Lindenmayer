# lindenmayer

An implementation of a Lindenmayer System.  Inspired by the article: 
"Algorithmic Composition: Computational Thinking in Music" by Michael Edwards
in the Communications of the ACM, Vol 54, No 7

## Usage

A Grammar takes the form of an Associative map of token to production sequence.
All symbols in the Grammar used must be non-terminal.

l-sys will construct a Lindenmayer System from a Grammar.

expand-n will expand an l-sys n times starting from a seed sequence.


## License

Copyright (C) 2011 Nick Orton

Distributed under the Eclipse Public License, the same as Clojure.
