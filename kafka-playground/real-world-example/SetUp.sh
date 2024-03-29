#!/bin/bash

# Prerequisites: tmux
# How to run:
# From terminal, run this script:sh ~/Downloads/GitRepositories/programming-playground/kafka/real-world-example/SetUp.sh
# tmux ls (to list all the tmux sessions)
# tmux attach -t kafkaRealWorldExampleSetUp (to attach to the session ListOfAppsToBeStarted)
# Ctrl-b w to select the window to jump to.

session="kafkaRealWorldExampleSetUp"
tmux new-session -d -s $session

window=0
tmux rename-window -t $session:$window 'startKafkaDockerContainers'
tmux send-keys -t $session:$window 'cd ~/Downloads/GitRepositories/programming-playground/kafka' C-m
tmux send-keys -t $session:$window 'docker-compose --file docker-compose-wurstmeister.yml up -d' C-m

window=1
tmux new-window -t $session:$window -n 'startKafkaUIClient'
tmux send-keys -t $session:$window 'docker run --network=host -p 8080:8080 -e KAFKA_BROKERS=localhost:9092 docker.redpanda.com/vectorized/console:latest' C-m

window=2
tmux new-window -t $session:$window -n 'startOpenSearchDockerContainers'
tmux send-keys -t $session:$window 'cd ~/Downloads/GitRepositories/programming-playground/opensearch' C-m
tmux send-keys -t $session:$window 'docker-compose --file docker-compose-opensearch.yml up -d' C-m

# And use this url in a browser: http://localhost:8080/topics to view the kafka topics

# And use this url in a browser: http://localhost:5601/app/dev_tools#/console to view OpenSearch UI dashboard

# Clean-up
# You can use "tmux kill-server" to cleanly and gracefully kill all tmux open sessions (and server).
# "docker stop $(docker ps -a -q)" to stop all the containers.
# "docker system prune -a" to clean up docker containers and images.

