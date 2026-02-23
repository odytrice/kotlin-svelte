# Kotlin Svelte Starter Project

<img src="./client/public/kotlin-svelte.svg" height="200">

This project is a starter template to build Single Page Applications using Kotlin (Spring Boot) and Svelte. It is bundled together using Gradle.

## Tools
- [Kotlin](https://kotlinlang.org)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Svelte](https://svelte.dev)
- [Vite](https://vite.dev/)
- [Gradle](https://gradle.org/)

## Running

1. Run `npx degit odytrice/kotlin-svelte my-app`
2. Run `cd my-app`
3. Run `./gradlew dev`
4. Navigate to http://localhost:3000

## Building

### Bundle
You can build and bundle the application with the following command

```bash
./gradlew bundle
```

Then you can copy the output bundle in `./.deploy`

### Docker

You can build a docker image using

```bash
docker build -t kotlin-svelte .
```

and then run it using

```bash
docker run -it -p 8080:8080 kotlin-svelte
```

Then visit http://localhost:8080

## Gradle Tasks

| Task | Description |
|------|-------------|
| `./gradlew build` | Builds both backend and frontend |
| `./gradlew dev` | Runs Spring Boot + Vite dev server in parallel |
| `./gradlew bundle` | Creates production bundle in `.deploy/` |
| `./gradlew test` | Runs backend tests |
| `./gradlew buildClient` | Builds only the Svelte frontend |
| `./gradlew clean` | Cleans all build artifacts |
