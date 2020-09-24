%% 10

%% Processes in Erlang:
%% This shows how two spawn independent processes that run in parallel.

%% Difference between a process and a thread:
%% a thread can share data with other threads - a process cannot share data.

-module(speak).

%% API
-export([run/0, say/2]).

%% 'done' is an Erlang keyword - indicates that the processing is complete. 
%% It does not have to return anything.

say(What, 0) ->
  done;
say(What, Times) ->
  io:fwrite(What ++ "\n"),
  say(What, Times -1).

%% Creating a process is very easy.
run() ->
  spawn(speak, say, ["Hi", 3]),
  spawn(speak, say, ["Bye", 3]).

%% The output from the console:
%%  2> speak:run().
%%  Hi
%%  Bye
%%  <0.89.0>
%%  Hi
%%  Bye
%%  Hi
%%  Bye
  
%% The `<0.89.0>` that is printed on the console is the process id.
%% After the process is complete, the process id is printed on the console.

%% The two processes run in parallel.
%% If one of them is faster than the other, the faster process will be completed first.
