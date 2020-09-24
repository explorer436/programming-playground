%% 4

-module(age).

%% API
-export([getAge/1]).

getAge(Name) ->
  AgeMap = #{"Alice" => 23, "Bob" => 25, "Carol" => 29},
  maps:get(Name, AgeMap, -1).

%% -1 is the default value.
%% We can remove it and if we pass a name that is not in the map, 
%% the function will throw an error.

%% To compile the file, in erlang shell, type "c(age)."
%% To run it, type "age:getAge("Alice")."
