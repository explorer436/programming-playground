%% 2

-module(factorial).

%% API
-export([factorial/1]).

%% demonstrates recursion

%% ";" indicates that the function is not over yet.
%% "N" has to be capital case. Not lowercase.
%% If we use a lowercase letter, it is called an Atom. Take a look at temperature.erl
factorial(1) ->
  1;

factorial(N) ->
  N * factorial(N-1).

%% To compile the file, in erlang shell, type "c(factorial)."
%% To run it, type "factorial:factorial(5)."