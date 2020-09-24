%% 7

-module(cardealer).

%% API
-export([listPrices/1]).

listPrices(Currency) ->
  CarList = getCarList(),
  printPrice(CarList, Currency).

%% Currency needs to be a parameter because the function needs two parameters.
printPrice([], Currency) ->
  true;
printPrice([Car | Rest], Currency) ->
  CarPricesMap = getCarPricesMap(),
  Price = maps:get(Car, CarPricesMap),
  ConvertedPrice = convertPrice(Price, Currency),
  io:fwrite("The price for " ++ Car ++ " is " ++ integer_to_list(ConvertedPrice) ++ "\n"),
  printPrice(Rest, Currency).

convertPrice(Price, Currency) ->
  case Currency of
    eur -> round(Price * 0.9);
    gbp -> round(Price * 0.75);
    usd -> Price
  end.

getCarList() ->
  ["BMW i8", "Laborghini Huracan", "Ferrari f12"].

getCarPricesMap() ->
  #{"BMW i8" => 150000, "Laborghini Huracan" => 500000, "Ferrari f12" => 700000}.