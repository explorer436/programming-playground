%% 13

%% This shows how two processes communicate with each other by passing data to each other.

-module(talkUsingDistributedProgramming).

%% API
-export([run/0, alice/0, bob/2, startAlice/0, startBob/1]).

alice() ->
  receive
    {message, BobNode} ->
      io:fwrite("Alice got a message\n"),
      BobNode ! message,
      alice();
    finished -> io:fwrite("Alice is finished\n")
  end.

%% the terminate function for bob
bob(0, AliceNode) ->
  {alice, AliceNode} ! finished,
  io:fwrite("Bob is finished\n");

%% Bob needs to send info about himself to Alice.
bob(N, AliceNode) ->
  {alice, AliceNode} ! {message, self()},
  receive
    message -> io:fwrite("Bob got a message\n")
  end,
  bob(N-1, AliceNode).


%% In this example, the two processes are on the same machine. But they don't have to be.
%% spawn returns a process id
%% register does not return a process id. It returns a boolean value.
run() ->
  register(alice, spawn(talkUsingDistributedProgramming, alice, [])),
  register(bob, spawn(talkUsingDistributedProgramming, bob, [3])).

startAlice() ->
  register(alice, spawn(talkUsingDistributedProgramming, alice, [])).

%% Bob needs to send the first message.
%% So, he needs to know AliceNode (The details about the computer on which AliceNode is running).
startBob(AliceNode) ->
  spawn(talkUsingDistributedProgramming, bob, [3, AliceNode]).

%% To test this, we have to start two terminals, 
%% startAlice() first
%% startBob() next
%% and run it from a third terminal and the two processes will talk to each other.
