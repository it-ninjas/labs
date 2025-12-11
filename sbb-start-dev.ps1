Write-Information "starting hugo-dev on http://localhost:8095"

podman run `
    --cap-drop all `
    --interactive `
    --name hugo-dev `
    --publish 127.0.0.1:8095:8095 `
    --rm `
    --tty `
    --volume ${pwd}:/src `
    hugomods/hugo:0.150.0@sha256:01f333546fe7e4c5cb136be29dd7ce549216ad5df1f9f92fc4e888f596907544 `
    server `
    -p 8095 `
    --bind 0.0.0.0
