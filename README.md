# api-meteo-notes

> Application **Spring Boot 3** de démonstration avec :
> - **/meteo** : endpoint météo simulée (JSON),
> - **/notes** : CRUD persistant (JPA + **H2**),
> - **UI** web légère intégrée (HTML/JS),
> - **Swagger UI** (OpenAPI) & **Actuator** (santé/metrics),
> - Dockerfile pour exécuter en conteneur.

![Java](https://img.shields.io/badge/Java-17%2B-red)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Build](https://img.shields.io/badge/Build-Maven-blue)
![DB](https://img.shields.io/badge/DB-H2-informational)

---

## ✨ Fonctionnalités

- **API REST** propre (validation, gestion d’erreurs JSON).
- **Persistance** via **Spring Data JPA** + **H2** (fichier local).
- **UI** statique intégrée (index.html) pour tester sans outil externe.
- **Documentation** interactive via **Swagger UI**.
- **Observabilité** via **Spring Boot Actuator**.
- **Docker** prêt pour build & run.

---

## ⚙️ Prérequis

- **Java JDK 17+** (Temurin/Adoptium recommandé)
- **Git**
- **Maven Wrapper** inclus (`./mvnw` / `mvnw.cmd`)
- (Facultatif) **Docker**

---

## 🚀 Démarrage rapide

```bash
# Cloner (SSH)
git clone git@github.com:zaka41a/api-meteo-notes.git
cd api-meteo-notes

# Build (exécute aussi les tests)
./mvnw clean package

# Lancer en dev
./mvnw spring-boot:run
