with Ada.Numerics.Elementary_Functions;
use Ada.Numerics.Elementary_Functions;

with Ada.Integer_Text_IO, Ada.Text_IO;
use Ada.Integer_Text_IO, Ada.Text_IO;

procedure ex2 is
   Number : Integer;
begin
   declare
      function Fact (N: Integer) return Integer is
      begin
         if N=0 then
            return 1;
         else 
            return N*Fact(N-1);
         end if;
      end Fact;  
   begin
      loop
         Put_Line("Insert the number");
         Get(Number);
         exit when Number = 0;
         Put("Factorial of ");
         Put(Number);
         Put(" is ");
         if Number > 0 then
            Put(Fact(Number));
         end if;
         Put_Line("");
     end loop;
   end;
end ex2;
