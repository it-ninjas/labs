wsl podman rm hugo-dev -f
wsl podman run   --rm --interactive   --publish 8095:8095   --name hugo-dev   -v $(pwd):/src  hugomods/hugo:0.135.0   server -p 8095 --bind 0.0.0.0