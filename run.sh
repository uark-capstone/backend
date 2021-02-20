#!/bin/sh
git reset --hard HEAD
git pull

./mvnw spring-boot:run