%% @author user
%% @doc @todo Add description to ex4.


-module(ex4).

%% ====================================================================
%% API functions
%% ====================================================================
-export([sum_max/2, int/1]).



%% ====================================================================
%% Internal functions
%% ====================================================================

sum_max([H1|T1],[H2|T2])-> hight(T1,H1) + hight(T2,H2).


hight([],C)->C;
hight([H|T],C) when H>C -> hight(T,H);
hight([_|T],C) -> hight(T,C).

int(L) -> int(L,[]).

int([],L2) -> L2;
int([H|T], L2) when is_integer(H) -> int(T, L2 ++ [H]);
int([_|T], L2) -> int(T, L2).