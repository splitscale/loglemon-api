#!/bin/bash

# Build Docker image
docker build -t kasutu/loglemon-api:latest .

# Push Docker image to repository
docker push kasutu/loglemon-api:latest
