Java assignment – Simple search engine
======================================
The goal of this assignment is to create a simple search engine in Java. The search engine should be implemented as an inverted index (http://en.wikipedia.org/wiki/Inverted_index) that runs in memory and can return a result list that is sorted by TF-IDF (http://en.wikipedia.org/wiki/Tf*idf).
The search engine should:
- be able to take in a list of documents
- support searches for single terms in the document set (http://en.wikipedia.org/wiki/Tokenization)
- return a list of matching documents sorted by TF-IDF

Example
The following documents are indexed:
Document 1: “the brown fox jumped over the brown dog” 
Document 2: “the lazy brown dog sat in the corner” 
Document 3: “the red fox bit the lazy dog”

A search for “brown” should now return the list: [document 1, document 2]. 
A search for “fox” should return the list: [document 1, document 3].


NOTE: The search engine does not need to persist the index to disk; a simple implementation in memory is fine. A document need only be a simple String. No GUI is needed, but you should be able to write a query and get a result back.
