wsl podman rm hugo-dev -f
wsl podman run   --rm --interactive   --publish 8095:8095   --name hugo-dev   -v $(pwd):/src   klakegg/hugo:0.81.0-ext-ubuntu   server -p 8095 --bind 0.0.0.0