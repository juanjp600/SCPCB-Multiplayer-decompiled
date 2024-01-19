Function find860angle%(arg0.npcs, arg1.forest)
    Local local0%
    Local local1%
    Local local2#
    Local local3#
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    tformpoint(entityx(arg0\Field73, $00), entityy(arg0\Field73, $00), entityz(arg0\Field73, $00), $00, arg1\Field4)
    local0 = (Int floor(((tformedx() + 6.0) / 12.0)))
    local1 = (Int floor(((tformedz() + 6.0) / 12.0)))
    tformpoint(entityx(arg0\Field4, $00), entityy(arg0\Field4, $00), entityz(arg0\Field4, $00), $00, arg1\Field4)
    local2 = ((tformedx() + 6.0) / 12.0)
    local3 = ((tformedz() + 6.0) / 12.0)
    local4 = (Int floor(local2))
    local5 = (Int floor(local3))
    If (((local4 <> local0) Or (local5 <> local1)) <> 0) Then
        For local6 = (Int max((Float (local4 - $01)), 0.0)) To (Int min((Float (local4 + $01)), 9.0)) Step $01
            For local7 = (Int max((Float (local5 - $01)), 0.0)) To (Int min((Float (local5 + $01)), 9.0)) Step $01
                If ((((arg1\Field2[((local7 * $0A) + local6)] > $00) And ((local6 <> local4) Or (local7 <> local5))) And ((local6 = local4) Or (local7 = local5))) <> 0) Then
                    If (((Abs (local0 - local6)) + (Abs (local1 - local7))) < ((Abs (local0 - local4)) + (Abs (local1 - local5)))) Then
                        tformpoint(((Float local6) * 12.0), 0.0, ((Float local7) * 12.0), arg1\Field4, $00)
                        Return (Int (point_direction(entityx(arg0\Field4, $00), entityz(arg0\Field4, $00), tformedx(), tformedz()) + 180.0))
                    EndIf
                EndIf
            Next
        Next
    Else
        Return (Int (point_direction(entityx(arg0\Field4, $00), entityz(arg0\Field4, $00), entityx(arg0\Field73, $00), entityz(arg0\Field73, $00)) + 180.0))
    EndIf
    Return $00
End Function
