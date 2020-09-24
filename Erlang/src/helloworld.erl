%% 1

-module(helloworld).

%% API
%% exports tell the outside users what functions this module has.
%% If a function is not exported, it cannot be accessed from outside the module.
%% The functions that need to be exported are exposed as comma-separated lists.
%% 0 and 1 represent the number of arguments the function takes.
%% Everything that is indented with two spaces represent the body of the function.
-export([helloworld/0, helloworld/1, hiworld/0]).

helloworld() ->
  "Hello world".
%% . represents the end of the function (similar to ; in Java)

helloworld(X) ->
  "Hello " ++ X.

hiworld() ->
  "hi world".


%% To compile the file, in erlang shell, type "c(helloworld)."
%% To run it, type "helloworld:helloworld()."
%% To run it, type "helloworld:helloworld("test")."
%% To run it, type "helloworld:hiworld()."
