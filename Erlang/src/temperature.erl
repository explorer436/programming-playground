%% 3

-module(temperature).

%% API
-export([convert/2, convert/1]).

%% "fahrenheit" and "celsius" are Atoms.
convert(F, fahrenheit) ->
  (F - 32) * 5 / 9;
convert(C, celsius) ->
  C * 9 / 5 + 32.
%% To compile the file, in erlang shell, type "c(temperature)."
%% To run it, type "temperature:convert(100, fahrenheit)."
%% To run it, type "temperature:convert(temperature:convert(100, fahrenheit), celsius)."

%% multi lines are separated by commas.

%% This is a Tuple : {fahrenheit, X}
%% This is a Tuple : {celsius, X}
convert({fahrenheit, X}) ->
  Y = (X - 32) * 5 / 9,
  {celsius, Y};
convert({celsius, X}) ->
  Y = X * 5 / 9 + 32,
  {fahrenheit, Y}.

%% To compile the file, in erlang shell, type "c(temperature)."
%% To run it, type "temperature:convert({fahrenheit, 100})."
%% To run it, type "temperature:convert(temperature:convert({fahrenheit, 100}))."
