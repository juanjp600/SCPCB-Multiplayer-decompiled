Function entitydistanceex#(arg0%, arg1%)
    Local local0#
    Local local1#
    Local local2#
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7#
    Local local8#
    Local local9#
    If (((arg0 <> $00) And (arg1 <> $00)) <> 0) Then
        local0 = entityx(arg0, $00)
        local1 = entityy(arg0, $00)
        local2 = entityz(arg0, $00)
        local3 = entityx(arg1, $00)
        local4 = entityy(arg1, $00)
        local5 = entityz(arg1, $00)
        local6 = (local3 - local0)
        local7 = (local4 - local1)
        local8 = (local5 - local2)
        local9 = (((local6 * local6) + (local7 * local7)) + (local8 * local8))
        Return sqr(local9)
    EndIf
    Return 0.0
    Return 0.0
End Function
