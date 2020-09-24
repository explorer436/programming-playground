%% 6

-module(greet).

%% API
-export([greet/1]).

%% demonstrates recursion using a for loop.
%% Erlang does not have native loops.

greet([]) ->
  true;

greet([First | Rest]) ->
  io:fwrite("Hello " ++ First ++ "\n"),
  greet(Rest).

%% To compile the file, in erlang shell, type "c(greet)."
%% To run it, type "greet:greet(["Alice", "Bob"])."