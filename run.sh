#!/bin/bash

mvn clean package
docker build -t pia/osvetlik ./
docker run --rm pia/osvetlik
