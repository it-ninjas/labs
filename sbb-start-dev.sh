#!/bin/bash

echo starting hugo-dev on http://localhost:8095

podman run --rm --interactive --publish 8095:8095 --name hugo-dev -v %cd%:/src hugomods/hugo:0.145.0 server -p 8095 --bind 0.0.0.0
