Function updateplayernetworklogic%(arg0.mp_player)
    Local local0%
    If (((arg0\Field4 <> Null) And (arg0\Field4\Field4 = $00)) <> 0) Then
        If (arg0\Field4\Field38 <> 0) Then
            arg0\Field7 = arg0\Field4\Field40
            arg0\Field8 = arg0\Field4\Field41
            arg0\Field9 = arg0\Field4\Field42
            For local0 = $00 To $04 Step $01
                arg0\Field4\Field23[local0] = peekshort(arg0\Field4\Field39, (local0 Shl $01))
            Next
            arg0\Field4\Field18 = readbool(arg0\Field21, $02)
            If (0.0 >= arg0\Field28) Then
                If (readbool(arg0\Field21, $00) <> 0) Then
                    arg0\Field28 = rnd(1.0, 2.0)
                EndIf
                If (readbool(arg0\Field21, $01) <> 0) Then
                    arg0\Field28 = rnd(2.0, 4.5)
                EndIf
            EndIf
            arg0\Field14 = (Int min((Float arg0\Field14), 7.0))
            arg0\Field4\Field38 = $00
        EndIf
        If (((60.0 < arg0\Field4\Field7) Lor arg0\Field4\Field37) <> 0) Then
            If (((((arg0\Field14 = $01) Lor (arg0\Field14 = $04)) Lor (arg0\Field14 = $06)) Lor (arg0\Field14 = $07)) <> 0) Then
                arg0\Field14 = $08
            ElseIf (((((arg0\Field14 = $02) Lor (arg0\Field14 = $03)) Lor (arg0\Field14 = $04)) Lor (arg0\Field14 = $05)) <> 0) Then
                arg0\Field14 = $09
            EndIf
        EndIf
    EndIf
    Return $00
End Function
