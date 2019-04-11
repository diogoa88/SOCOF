%% @author user
%% @doc @todo Add description to ex5.


-module(ex5).

%% ====================================================================
%% API functions
%% ====================================================================
-export([grades/1]).



%% ====================================================================
%% Internal functions
%% ====================================================================


grades([{HeadName, HeadGrade}|T]) -> Average = calculateAverage([{HeadName, HeadGrade}|T]) , 
									 {BiggerGrade, BiggerName}=calculateBigger(T, HeadGrade, HeadName) , 
									 {LowerGrade, LowerName}=calculateLower(T, HeadGrade, HeadName), 
									 io:fwrite("Average: ~w ~nBigger: Name -> ~s , Grade -> ~w ~nLower: Name-> ~s , Grade-> ~w ~n", [Average,BiggerName,BiggerGrade,LowerName,LowerGrade]).
			 

	
calculateBigger([],B,N) -> {B,N};
calculateBigger([{Name, Grade}|T],B,_) when Grade>B -> calculateBigger(T, Grade, Name);
calculateBigger([_|T], B, N) -> calculateBigger(T, B, N).

calculateLower([],B,N) -> {B,N};
calculateLower([{Name, Grade}|T],B,_) when Grade<B -> calculateLower(T, Grade, Name);
calculateLower([_|T], B, N) -> calculateLower(T, B, N).
			 
			 
calculateAverage(L) -> NL = createListGrades(L,[]), average(NL).
					   					
createListGrades([],NL) -> NL;
createListGrades([{_, Grade}|T], NL) -> createListGrades(T,NL ++ [Grade]).
								   
average([]) -> 0;
average(L)-> sum(L) / count(L).

sum([])-> 0;
sum([H|T])-> H + sum(T).

count([]) -> 0;
count([_|T]) -> 1 + count(T).