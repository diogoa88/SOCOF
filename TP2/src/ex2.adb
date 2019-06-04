
with Calendar, Ada.Text_IO, Ada.Integer_Text_IO, Ada.Numerics.Discrete_Random;
use Calendar, Ada.Text_IO, Ada.Integer_Text_IO;

procedure Ex2 is

   NumberSensor : Integer :=5;
   type Rand_Range is range 0..1;

   task Central;
   task type Sensor is
      entry CheckWater ( WaterExists : out Rand_Range);
   end Sensor;

   task body Sensor is
   package Rand_Int is new Ada.Numerics.Discrete_Random(Rand_Range);
   seed : Rand_Int.Generator;
   begin
      delay 10.0;
      loop
         accept CheckWater( WaterExists : out Rand_Range) do
            Rand_Int.Reset(seed);
            WaterExists := Rand_Int.Random(seed);
            end CheckWater;
      end loop;
   end Sensor;

   type Sensors is array (Integer range 1 .. NumberSensor) of Sensor;
   Alarm : Sensors;


   task body Central is
      Interval : constant Duration := Duration (1);
      WaterExists : Rand_Range;
   begin
      loop
         for I in 1 .. NumberSensor loop
            select
               Alarm (I).CheckWater(WaterExists); -- queries sensors
               Put("Sensor number ");
               Put (I);
               if WaterExists = 1 then --detect water
                  Put_Line (" detected water.");
               else
                  Put_Line( " didn't detect water.");
               end if;

            or
               delay Interval;
               Put ("Sensor number ");
               Put (I);
               Put_Line (" didn't answer.");
            end select;
         end loop;
         delay 5.0; --wait 5 seconds
      end loop;
   end Central;



begin
   --  Insert code here.
   null;
end Ex2;
