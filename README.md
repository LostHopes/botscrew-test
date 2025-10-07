# Requirements

- Java >= 25
- Docker (optional)

# Build instructions

```sh
./gradlew build
```
or

```sh
./gradlew clean build
```

and then run

```sh
java -jar build/libs/university-0.0.1-SNAPSHOT.jar
```

## With docker

```sh
sudo docker build -t university .
sudo docker run -it university /bin/bash
```