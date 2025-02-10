# IT Ninjas Labs


The techlab is available on GitHub Pages [here](https://labs.it-ninjas.ch)


## Content Sections

The training content resides within the [content](content) directory.

The main part are the labs, which can be found at [content/en/docs](content/en/docs).


## Hugo

This site is built using the static page generator [Hugo](https://gohugo.io/).

The page uses the [docsy theme](https://github.com/google/docsy) which is included as a Git Submodule.
Docsy is being enhanced using [docsy-plus](https://github.com/puzzle/docsy-plus/) as well as
[docsy-puzzle](https://github.com/puzzle/docsy-puzzle/)
for brand specific settings.

After cloning the main repo, you need to initialize the submodule like this:

```bash
git submodule update --init --recursive
```

The default configuration uses the puzzle setup from [config/_default](config/_default/config.toml).
Further, specialized environments can be added in the `config` directory.


### Docsy theme usage

* [Official docsy documentation](https://www.docsy.dev/docs/)
* [Docsy Plus](https://github.com/puzzle/docsy-plus/)


### Update submodules for theme updates

Run the following command to update all submodules with their newest upstream version:

```bash
git submodule update --remote
```


## Build using Docker

Build the image:

```bash
docker build -t puzzle-bbt/training-sbb-puzzle:latest .
```

Run it locally:

```bash
docker run -i -p 8080:8080 puzzle-bbt/training-sbb-puzzle
```


### Using Buildah and Podman

Build the image:

```bash
buildah build-using-dockerfile -t puzzle-bbt/training-sbb-puzzle:latest .
```

Run it locally with the following command. Beware that `--rmi` automatically removes the built image when the container stops, so you either have to rebuild it or remove the parameter from the command.

```bash
podman run --rm --rmi --interactive --publish 8080:8080 localhost/puzzle-bbt/training-sbb-puzzle:latest
```


## How to develop locally

To develop locally we don't want to rebuild the entire container image every time something changed, and it is also important to use the same hugo versions like in production.
We simply mount the working directory into a running container, where hugo is started in the server mode.

If you have docker-compose installed simply run:


```bash
docker-compose up
```

```bash
export HUGO_VERSION=$(grep "FROM klakegg/hugo" Dockerfile | sed 's/FROM klakegg\/hugo://g' | sed 's/ AS builder//g')
docker run \
  --rm --interactive \
  --publish 8080:8080 \
  -v $(pwd):/src \
  klakegg/hugo:${HUGO_VERSION} \
  server -p 8080 --bind 0.0.0.0
```

### Linting of Markdown content

Markdown files are linted with [prettier](https://prettier.io/docs/en/options).
It can be configured with [.prettierrc](.prettierrc) and [.prettierignore](.prettierignore).

Locally it should be executed before each commit with a pre-commit hook, managed by [husky](https://typicode.github.io/husky/).
If you want to run it manually, you can do so from the commandline:

```bash
npm install
npm run format
```

### Test for broken links

The fully builded Hugo site (meaning the generated `./public` directory) can automatically scanned for broken links. The tool used is [htmltest](https://github.com/wjdp/htmltest). To check manually install htmltest and then run:

```bash
htmltest
```

The test is configured with the options in [.htmltest.yml](./.htmltest.yml). All the config options are available [here](https://github.com/wjdp/htmltest#wrench-configuration). 

## Github Actions

### Quality
The [quality action](.github/workflows/quality.yml) is fired on each push. It does the following:
* build the Hugo site
* test if the linting is OK
* test if any broken links are present in the generated HTML

### Test

The [test action](.github/workflows/test.yml) is fired on each push to a feature branch and does the following:

* builds the Hugo site




### Push Main

The [push main action](.github/workflows/main.yml) is fired when a commit is pushed to the main branch (eg. a PR is merged) and does the following:

* builds the Hugo site
* deploys it to GitHub pages

## Contributions

If you find errors, bugs or missing information please help us improve and have a look at the [Contribution Guide](CONTRIBUTING.md).
