#!/bin/bash

# Run Docker container
docker run --name loglemon-api -p 8081:8080 -d kasutu/loglemon-api:latest
