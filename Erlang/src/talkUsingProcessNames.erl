%% 12

%% The difference between talkByPassingMessages and this is,
%% in talkByPassingMessages, the process ids are interchanged.

%% This shows how two processes communicate with each other by passing data to each other.
%% We can get around it by using Erlang's built in `register` function.
%% register takes an Atom and a process as input parameters.
%% So, here we will register both the processes and the two processes will communicate with each other.

-module(talkUsingProcessNames).

%% API
-export([run/0, alice/0, bob/1]).

alice() ->
  receive
    message ->
      io:fwrite("Alice got a message\n"),
      bob ! message,
      alice();
    finished -> io:fwrite("Alice is finished\n")
  end.

%% the terminate function for bob
bob(0) ->
  alice ! finished,
  io:fwrite("Bob is finished\n");

%% Bob needs to send info about himself to Alice.
bob(N) ->
  alice ! message,
  receive
    message -> io:fwrite("Bob got a message\n")
  end,
  bob(N-1).


%% In this example, the two processes are on the same machine. But they don't have to be.
%% spawn returns a process id
%% register does not return a process id. It returns a boolean value.
%% This is why `true` is printed on the console.
run() ->
  register(alice, spawn(talkUsingProcessNames, alice, [])),
  register(bob, spawn(talkUsingProcessNames, bob, [3])).

%% > talkUsingProcessNames:run().
%% Alice got a message
%% true
%% Bob got a message
%% Alice got a message
%% Bob got a message
%% Alice got a message
%% Bob got a message
%% Bob is finished
%% Alice is finished
