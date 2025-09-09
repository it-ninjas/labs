FROM hugomods/hugo:0.150.0@sha256:01f333546fe7e4c5cb136be29dd7ce549216ad5df1f9f92fc4e888f596907544 AS builder

ARG HUGO_ENV=default

COPY . /src

RUN hugo --environment ${HUGO_ENV} --minify

FROM nginxinc/nginx-unprivileged:alpine@sha256:5a3deab083279228447546aa54db9ab82e43065cac3e38f70b2b2a6cdbf57f7a

EXPOSE 8080

COPY --from=builder /src/public /usr/share/nginx/html
