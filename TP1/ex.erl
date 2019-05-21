-module(ex).

-define (NumberOfTriage, 2).
-define (TimeOutTriage, 4000).
-define (MaxPriority, 3).

-export([start/0, registerPerson/1, waitingList/1, addToList/2, getFistElement/1,
        createNTriage/1, triage/1,
        test/0]).




%% Start the program
start() -> register(waitingList, spawn(ex, waitingList,[[]])),
            createNTriage(?NumberOfTriage).

test()->
    registerPerson("Peter"),
    registerPerson("Andre"),
    registerPerson("Diogo"),
    registerPerson("Manel"),
    registerPerson("Ricardo"),
    registerPerson("Sofia"),
    registerPerson("Tiago").

%%Add Person to WaitingList
registerPerson(Name) -> waitingList ! {add , Name}.

%%The waiting List
waitingList(List) -> 
    receive
        {add, Name} -> io:format("Name: ~s ~n", [Name]),
                        NewList=addToList(List,Name), 
                        waitingList(NewList);
        {get, Pid} ->   {First, NewList} = getFistElement(List),
                        Pid ! First,
                        waitingList(NewList)
    end.

%%create N Triage
createNTriage(0)-> ok;
createNTriage(Number)-> spawn(ex, triage,[Number]), createNTriage(Number-1).

%%triage
triage(Number) -> 
    receive
    after(?TimeOutTriage) -> io:format("Timeout ~n"),
         waitingList ! {get , self()} ,
        receive
            error -> io:format("Triage ~w cant get a pacient ~n", [Number]);
            Name -> Priority = rand:uniform(?MaxPriority),
                    io:format("Triage ~w get a pacient ~s with Priority ~w ~n", [Number, Name, Priority])
        end,
     triage(Number)
    end.




%% add element to the end of the list
addToList(List,Element) -> List ++ [Element].

%% get First element of a list
getFistElement([]) -> {error, []};
getFistElement([H|T]) -> {H,T}.