%% 11

%% This shows how two processes communicate with each other by passing data to each other.

-module(talkByPassingMessages).

%% API
-export([run/0, alice/0, bob/2]).

%% Alice is expected to receive the messages that Bob is sending to her.
%% When alice() is spawned, she will start listening.
%% She will keep listening until Bob sends a `finished` message to her.
alice() ->
  receive
    {message, PId} ->
      io:fwrite("Alice got a message\n"),
      PId ! message,
      alice();
    finished -> io:fwrite("Alice is finished\n")
  end.

%% the terminate function for bob
%% send a message to Alice that he is finished.
bob(0, PId) ->
  PId ! finished,
  io:fwrite("Bob is finished\n");

%% Bob needs to send info about himself to Alice.
%% N is the number of messages that should be sent between Bob and Alice.
%% ! means - send a message.
%% self() is a built in function in Erlang.
bob(N, PId) ->
  PId ! {message, self()},
  receive
    message -> io:fwrite("Bob got a message\n")
  end,
  bob(N-1, PId).


%% In this example, the two processes are on the same machine. But they don't have to be.
%% spawn returns a process id
%% register does not return a process id. It returns a boolean value.
run() ->
  PId = spawn(talkByPassingMessages, alice, []),
  spawn(talkByPassingMessages, bob, [3, PId]).

%% console output:
%% talkByPassingMessages:run().
%% Alice got a message
%% <0.89.0>
%% Bob got a message
%% Alice got a message
%% Bob got a message
%% Alice got a message
%% Bob got a message
%% Bob is finished
%% Alice is finished
