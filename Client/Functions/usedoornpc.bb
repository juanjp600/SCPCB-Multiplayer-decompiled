Function usedoornpc%(arg0.npcs, arg1%, arg2%)
    Local local0#
    Local local1%
    local0 = entitydistancesquared(arg0\Field3, arg0\Field39[arg0\Field42]\Field0)
    If (arg0\Field4 = $15) Then
        If (1.0 > local0) Then
            If (arg0\Field39[arg0\Field42]\Field1 <> Null) Then
                If ((((arg0\Field39[arg0\Field42]\Field1\Field6 = $00) And (arg0\Field39[arg0\Field42]\Field1\Field10 <> $04)) And (arg0\Field39[arg0\Field42]\Field1\Field10 <> $01)) <> 0) Then
                    openclosedoor(arg0\Field39[arg0\Field42]\Field1, arg1, arg2)
                    If (arg1 <> 0) Then
                        playsoundex(npcsound[$00], camera, arg0\Field0, 8.0, 1.0, $00, $00)
                    EndIf
                    If (arg0\Field39[arg0\Field42]\Field1\Field23 <> 0) Then
                        arg0\Field39[arg0\Field42]\Field1\Field13 = 350.0
                    EndIf
                EndIf
            EndIf
            If (0.04 > local0) Then
                arg0\Field42 = (arg0\Field42 + $01)
            EndIf
        EndIf
    ElseIf (0.49 > local0) Then
        local1 = $01
        If (arg0\Field39[arg0\Field42]\Field1 <> Null) Then
            If (((arg0\Field39[arg0\Field42]\Field1\Field6 = $00) And (((((((arg0\Field39[arg0\Field42]\Field1\Field10 = $01) Lor (arg0\Field39[arg0\Field42]\Field1\Field4 > $00)) Lor (arg0\Field39[arg0\Field42]\Field1\Field14 <> $00)) Lor (arg0\Field39[arg0\Field42]\Field1\Field19 <> $00)) Lor (arg0\Field39[arg0\Field42]\Field1\Field3[$00] = $00)) Lor (arg0\Field39[arg0\Field42]\Field1\Field3[$01] = $00)) Lor ((arg0\Field39[arg0\Field42]\Field1\Field6 = $00) And (arg0\Field39[arg0\Field42]\Field1\Field10 = $04)))) <> 0) Then
                local1 = $00
            ElseIf (arg0\Field39[arg0\Field42]\Field1\Field6 = $00) Then
                openclosedoor(arg0\Field39[arg0\Field42]\Field1, arg1, arg2)
                If (arg0\Field4 = $02) Then
                    arg0\Field39[arg0\Field42]\Field1\Field13 = 175.0
                EndIf
            EndIf
        EndIf
        If (((0.04 > local0) And local1) <> 0) Then
            arg0\Field42 = (arg0\Field42 + $01)
        ElseIf (((0.25 > local0) And (local1 = $00)) <> 0) Then
            arg0\Field40 = $00
            arg0\Field41 = 420.0
            arg0\Field42 = $00
        EndIf
    EndIf
    Return $00
End Function
