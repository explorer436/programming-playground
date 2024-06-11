# build the executable
FROM fpco/stack-build:latest AS build-env

RUN mkdir /opt/build
COPY containerizing-a-haskell-app.cabal stack.yaml /opt/build/
# Pre-install the library dependencies for the end goal of reducing the docker image build time (stack build).
RUN cd /opt/build && stack install --only-dependencies --system-ghc
COPY . /opt/build
# From Stack documentation: 
# build                    Build the package(s) in this directory/configuration.
# install                  Shortcut for 'build --copy-bins'.
# Stack installs executables to: $HOME/.local/bin
# build executable and install to /root/local/.bin
RUN cd /opt/build && stack install --system-ghc


FROM debian:stable-slim
RUN mkdir -p /opt/containerizing-a-haskell-app
WORKDIR /opt/containerizing-a-haskell-app
COPY --from=build-env /root/.local/bin/containerizing-a-haskell-app-exe /opt/containerizing-a-haskell-app/containerizing-a-haskell-app.exe
CMD ["/opt/containerizing-a-haskell-app/containerizing-a-haskell-app.exe"]