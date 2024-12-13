# Dice Rolling API

Ce projet fournit une API REST pour lancer des dés, enregistrer les résultats et consulter les historiques des lancers.

## Routes Disponibles

### Lancer un seul dé
- **URL** : `/api/rollDice`
- **Méthode** : `GET`
- **Description** : Lance un seul dé à 6 faces et retourne le résultat.
- **Exemple de réponse** :
  ```json
  4
  ```

---

### Lancer plusieurs dés
- **URL** : `/api/rollDices/{count}`
- **Méthode** : `GET`
- **Description** : Lance plusieurs dés à 6 faces et retourne les résultats.
- **Paramètre** :
  - `count` (int) : Nombre de dés à lancer.
- **Exemple de réponse** :
  ```json
  [3, 5, 6, 2]
  ```

---

### Consulter les historiques des lancers
- **URL** : `/api/diceLogs`
- **Méthode** : `GET`
- **Description** : Retourne la liste des historiques des lancers de dés, avec les résultats et la date/heure de chaque lancer.
- **Exemple de réponse** :
  ```json
  [
    {
      "diceCount": 1,
      "results": [4],
      "timestamp": "2024-12-13T15:30:00"
    },
    {
      "diceCount": 3,
      "results": [5, 2, 6],
      "timestamp": "2024-12-13T15:35:00"
    }
  ]
  ```

---

## Documentation Swagger

La documentation Swagger de l'API est accessible à l'adresse suivante :
[Swagger UI](http://localhost:8081/swagger-ui/index.html)

