SpotifytoSQlite.github.io


En el trabajo realizado se ha creado un proyecto java en IntelliJ, el cuál traslada todos los álbumes y canciones de 5 artistas elegidos de la api de Spotify a una base de datos SQL.
Dicho proyecto se ha dividido en 4 paquetes, api, controller, model y sqlite: 
 En el paquete “api” se encuentra la clase SpotifyAccessor, la cual nos permite acceder a la web api de Spotify mediante el uso de la otra clase también implementada en dicho paquete, SpotifyAuthorization. 
En el paquete “controller” se encuentran la clases “Controller”, esta se encarga de hacerle las peticiones a la api de Spotify mediante GETS, y estos les devuelven listas de objetos.
En el paquete “model” encontramos 3 clases, “Artist”, “Album” y “Track”. Estas clases pojo son el modelo de los objeto usados.
En el paquete “sqlite” se encuentran las clases “Translate” y “SQLiteMusicDatabase”, la primera nos traduce el objeto dado y nos lo traduce a sentencia SQL. Mientras que la segunda clase crea una tabla e inserta las sentencias SQL recibidas por la clase “Translate”.
Por último, en la clase “Main” hacemos las llamadas para obtener el resultado del proyecto.
