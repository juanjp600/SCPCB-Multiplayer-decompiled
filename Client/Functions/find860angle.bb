Function find860angle#(arg0.npcs, arg1.forest)
    Local local0#
    Local local1#
    Local local2#
    Local local3#
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    tformpoint(entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00), $00, arg1\Field4)
    local0 = floor(((tformedx() + 6.0) / 12.0))
    local1 = floor(((tformedz() + 6.0) / 12.0))
    tformpoint(entityx(arg0\Field3, $00), entityy(arg0\Field3, $00), entityz(arg0\Field3, $00), $00, arg1\Field4)
    local2 = ((tformedx() + 6.0) / 12.0)
    local3 = ((tformedz() + 6.0) / 12.0)
    local4 = (Int floor(local2))
    local5 = (Int floor(local3))
    If (((local0 <> (Float local4)) Lor (local1 <> (Float local5))) <> 0) Then
        local8 = (Int max((Float (local4 - $01)), 0.0))
        local9 = (Int min((Float (local4 + $01)), 9.0))
        local10 = (Int max((Float (local5 - $01)), 0.0))
        local11 = (Int min((Float (local5 + $01)), 9.0))
        For local6 = local8 To local9 Step $01
            For local7 = local10 To local11 Step $01
                If ((((arg1\Field2[((local7 * $0A) + local6)] > $00) And ((local6 <> local4) Lor (local7 <> local5))) And ((local6 = local4) Lor (local7 = local5))) <> 0) Then
                    If (((Abs (local0 - (Float local4))) + (Abs (local1 - (Float local5)))) > ((Abs (local0 - (Float local6))) + (Abs (local1 - (Float local7))))) Then
                        tformpoint(((Float local6) * 12.0), 0.0, ((Float local7) * 12.0), arg1\Field4, $00)
                        Return (pointdirection(entityx(arg0\Field3, $00), entityz(arg0\Field3, $00), tformedx(), tformedz()) + 180.0)
                    EndIf
                EndIf
            Next
        Next
    Else
        Return (pointdirection(entityx(arg0\Field3, $00), entityz(arg0\Field3, $00), entityx(me\Field60, $00), entityz(me\Field60, $00)) + 180.0)
    EndIf
    Return 0.0
End Function
