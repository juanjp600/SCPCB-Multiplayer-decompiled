Function isinsideelevator%(arg0#, arg1#, arg2#, arg3%)
    Local local0#
    local0 = ((fps\Field7[$00] * 0.015) + 1.09375)
    Return (((local0 > (Abs (arg0 - entityx(arg3, $01)))) And (local0 > (Abs (arg2 - entityz(arg3, $01))))) And (local0 > (Abs (arg1 - entityy(arg3, $01)))))
    Return $00
End Function
