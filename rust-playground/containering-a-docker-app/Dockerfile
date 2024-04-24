# syntax=docker/dockerfile:1

FROM rust:1.71 as builder

# Update Rust
# Update your stable version by running "rustup update stable"
# If you want to use nightly version, use this:
RUN rustup default nightly && rustup update
  #If not, we will run into errors like this.
  #error: failed to compile `bee-nice v0.1.0 (/usr/src/bee-nice)`, intermediate artifacts can be found at `/usr/src/bee-nice/target`
  #
  #Caused by:
  #  failed to parse manifest at `/usr/local/cargo/registry/src/github.com-1ecc6299db9ec823/byteorder-1.5.0/Cargo.toml`
  #
  #Caused by:
  #  feature `edition2021` is required

# The WORKDIR can by anything like /usr/src/my-app. It doesn't have to match the name of the application exactly.
WORKDIR /usr/src/containering-a-docker-app

COPY . .
RUN cargo install --path .

FROM debian:stable-slim
WORKDIR /app
COPY --from=builder /usr/local/cargo/bin/containering-a-docker-app /usr/local/bin/containering-a-docker-app
COPY --from=builder /usr/src/containering-a-docker-app/web ./web
EXPOSE 8080
CMD ["containering-a-docker-app"]