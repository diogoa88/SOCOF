%% @author user
%% @doc @todo Add description to ex3.


-module(ex3).

%% ====================================================================
%% API functions
%% ====================================================================
-export([count/1, member/2, delete/2, reverse/1, average/1]).



%% ====================================================================
%% Internal functions
%% ====================================================================

count([]) -> 0;
count([_|T]) -> 1 + count(T).

member(_,[])->false;
member(E,[H|_]) when E =:=H -> true;
member(E,[_|T]) -> member(E,T).

delete(_,[])-> [];
delete(E,[H|T]) when E=:=H -> delete(E,T);
delete(E,[H|T]) -> [H|delete(E,T)].

reverse([]) -> [];
reverse([H|T])-> reverse(T) ++ [H].

average([]) -> 0;
average(L)-> sum(L) / count(L).

sum([])-> 0;
sum([H|T])-> H + sum(T).