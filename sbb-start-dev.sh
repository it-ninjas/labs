#!/bin/bash

echo starting hugo-dev on http://localhost:8095

podman run --rm --interactive --publish 8095:8095 --name hugo-dev -v %cd%:/src klakegg/hugo:0.81.0-ext-ubuntu server -p 8095 --bind 0.0.0.0
