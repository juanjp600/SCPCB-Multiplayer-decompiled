Function multiplayer_updateplayeranimations%(arg0.players)
    Local local0.breachtypes
    If (((arg0\Field12 = $00) Or (arg0\Field78 = $00)) <> 0) Then
        Return $00
    EndIf
    local0 = getbreachtype(arg0\Field51)
    If (arg0\Field40 <> $00) Then
        local0 = getbreachtype(classd_model)
    EndIf
    Select arg0\Field56
        Case $0F
            If (local0\Field16[$0F] <> $00) Then
                If (((arg0\Field57 = $00) And (animlength(arg0\Field12) > $01)) <> 0) Then
                    setanimtime(arg0\Field12, 1.0, $00)
                    arg0\Field57 = arg0\Field56
                EndIf
                animate2(arg0\Field12, animtime(arg0\Field12), getfirstpackedvalue(local0\Field16[$0F]), getsecondpackedvalue(local0\Field16[$0F]), local0\Field17[$0F], $00)
                If ((Float (getsecondpackedvalue(local0\Field16[$0F]) - $01)) <= animtime(arg0\Field12)) Then
                    If (local0\Field16[$10] <> $00) Then
                        arg0\Field56 = $10
                    Else
                        arg0\Field56 = $00
                        arg0\Field57 = $00
                    EndIf
                EndIf
                Return $00
            EndIf
        Case $10
            If (local0\Field16[$0F] <> $00) Then
                animate2(arg0\Field12, animtime(arg0\Field12), getfirstpackedvalue(local0\Field16[$10]), getsecondpackedvalue(local0\Field16[$10]), local0\Field17[$10], $00)
                If ((Float (getfirstpackedvalue(local0\Field16[$10]) + $01)) >= animtime(arg0\Field12)) Then
                    arg0\Field56 = $00
                    arg0\Field57 = $00
                EndIf
                Return $00
            EndIf
    End Select
    If (arg0\Field55 < $1E) Then
        If (((arg0\Field37 = $00) Or (arg0\Field37 > $0A)) <> 0) Then
            If (local0\Field16[arg0\Field55] = $00) Then
                animate2(arg0\Field12, animtime(arg0\Field12), getfirstpackedvalue(local0\Field16[$0C]), getsecondpackedvalue(local0\Field16[$0C]), local0\Field17[$0C], $01)
            Else
                animate2(arg0\Field12, animtime(arg0\Field12), getfirstpackedvalue(local0\Field16[arg0\Field55]), getsecondpackedvalue(local0\Field16[arg0\Field55]), local0\Field17[arg0\Field55], $01)
            EndIf
        ElseIf (local0\Field18[arg0\Field55] = $00) Then
            animate2(arg0\Field12, animtime(arg0\Field12), getfirstpackedvalue(local0\Field18[$0C]), getsecondpackedvalue(local0\Field18[$0C]), local0\Field19[$0C], $01)
        Else
            animate2(arg0\Field12, animtime(arg0\Field12), getfirstpackedvalue(local0\Field18[arg0\Field55]), getsecondpackedvalue(local0\Field18[arg0\Field55]), local0\Field19[arg0\Field55], $01)
        EndIf
    EndIf
    Return $00
End Function
