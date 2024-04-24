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

WORKDIR /usr/src/hello-world-rest-service

COPY . .
RUN cargo install --path .

FROM debian:stable-slim
WORKDIR /app
COPY --from=builder /usr/local/cargo/bin/hello-world-rest-service /usr/local/bin/hello-world-rest-service
COPY --from=builder /usr/src/hello-world-rest-service/web ./web
EXPOSE 8080
CMD ["hello-world-rest-service"]