%% @author user
%% @doc @todo Add description to ex3.

-module(ex3).

%% ====================================================================
%% API functions
%% ====================================================================
-export([open_Account/2, server/1, start_server/0, consult/1, deposit/2 , withdraw/2]).

%% ====================================================================
%% Internal functions
%% ====================================================================

start_server() ->
    Pid = spawn(ex3, server, [[]]), register(bank, Pid).

server ( List ) -> 
	receive 
		{ open_Account , Client , InitialAmount , PidClient } -> 
			case checkAccount ( Client , List ) of
				not_found -> PidClient ! "Account added successfully",
				NewList =  [{Client, InitialAmount} | List];
				_ -> PidClient ! "Account already exist", 
				NewList = List
			end;

		{consult , Client , PidClient } -> 
			case checkAccount ( Client , List ) of
				not_found -> PidClient ! {"not_found"};
				Amount -> PidClient ! {"ok", Amount}
			end,
			NewList = List;
		{deposit, Client, Amount, PidClient} ->
			case checkAccount ( Client , List ) of
				not_found -> PidClient ! "not_found", NewList = List;
				_ -> NewList = addMoney(Client,Amount,List),
				PidClient ! "ok"
			end;
		{withdraw, Client, Amount, PidClient} -> 
				case checkAccount ( Client , List ) of
				Amount2 when Amount2>Amount -> 
					NewList = removeMoney(Client,Amount,List) , PidClient ! "ok";
				not_found -> PidClient ! "not_found", NewList = List
				end
			end,
	server(NewList).


checkAccount(_, []) -> not_found;
checkAccount(Client, [{Client, Amount} | _]) -> Amount;
checkAccount(Client, [_ | T]) ->
    checkAccount(Client, T).

open_Account(Client, InitialAmount) ->
    bank ! {open_Account, Client, InitialAmount, self()},
    receive R -> io:format("~s\n", [R]) end.

consult(Client) ->
    bank ! {consult, Client, self()},
    receive
      {"ok", Value} -> io:format("The account have ~w\n", [Value]);
      {"not_found"} -> io:format("Account not found\n")
    end.

deposit(Client, Amount) ->
	bank ! {deposit, Client, Amount, self()},
	receive
	  "ok" -> io:format("Value added successfully\n");
      "not_found" -> io:format("Not Found")
    end.

addMoney(Client,Amount,[{Client,OldAmount}|T]) -> [{Client, OldAmount + Amount} | T];
addMoney(Client, Amount, [ H|T]) -> [H|addMoney(Client,Amount,T)].

withdraw(Client, Amount) ->
	bank ! {withdraw, Client,Amount, self()},
	receive
	  "ok" -> io:format("Value removed successfully\n");
      "not_found" -> io:format("Not Found")
    end.		

removeMoney(Client,Amount,[{Client,OldAmount}|T]) -> [{Client, OldAmount - Amount} | T];
removeMoney(Client, Amount, [ H|T]) -> [H|removeMoney(Client,Amount,T)].