%% 5

-module(calendar).

%% API
-export([leap/1, day/2]).

%% demonstrates if-else and switch statements.

leap(Year) ->
  if
    Year rem 400 == 0 -> leap;
    Year rem 100 == 0 -> non_leap;
    Year rem 4 == 0 -> leap;
    true -> non_leap
  end.

%% Gives the number of days in a month of a year.
day(Month, Year) ->
  Leap = leap(Year),
  case Month of
    jan -> 31;
    feb when Leap == leap -> 29;
    feb -> 28;
    mar -> 31;
    apr -> 30;
    may -> 31;
    jun -> 30;
    jul -> 31;
    aug -> 31;
    sep -> 30;
    oct -> 31;
    nov -> 30;
    dec -> 31
  end.


%% To compile the file, in erlang shell, type "c(calendar)."
%% To run it, type "calendar:leap(2000)."
%% To run it, type "calendar:leap(2019)."
%% To run it, type "calendar:leap(0)."
