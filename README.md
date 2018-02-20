# MultiDatabase
Multi Database Service

Project with examples of multiple database service implementations and cross-service interaction.

Project contains CRUD-service implementations:
* Cassandra
* JPA
* MongoDB
* Neo4j
* Redis

Also there is service with multi-cache level system, where hierarchy is represented like this:
* JPA -> Mongo -> Redis

Where each layer is layer *(1/2/3)* cache in this chain.

All this is just a simple demo.

*2017*
