Function findspectateplayer%(arg0%)
    Local local0%
    Local local1%
    If (arg0 = $00) Then
        If ((spectate\Field1 - $01) >= $00) Then
            local0 = spectate\Field1
            local1 = (spectate\Field1 - $01)
            While (local1 >= $01)
                If (player[local1] <> Null) Then
                    If (player[local1]\Field51 <> $00) Then
                        spectate\Field1 = local1
                        Exit
                    EndIf
                EndIf
                local1 = (local1 + $FFFFFFFF)
            Wend
            If (local0 = spectate\Field1) Then
                For local1 = (spectate\Field1 + $01) To networkserver\Field14 Step $01
                    If (player[local1] <> Null) Then
                        If (player[local1]\Field51 <> $00) Then
                            spectate\Field1 = local1
                        EndIf
                    EndIf
                Next
            EndIf
        EndIf
    Else
        local0 = spectate\Field1
        For local1 = (spectate\Field1 + $01) To networkserver\Field14 Step $01
            If (player[local1] <> Null) Then
                If (player[local1]\Field51 <> $00) Then
                    spectate\Field1 = local1
                    Exit
                EndIf
            EndIf
        Next
        If (local0 = spectate\Field1) Then
            local1 = (spectate\Field1 - $01)
            While (local1 >= $01)
                If (player[local1] <> Null) Then
                    If (player[local1]\Field51 <> $00) Then
                        spectate\Field1 = local1
                    EndIf
                EndIf
                local1 = (local1 + $FFFFFFFF)
            Wend
        EndIf
    EndIf
    Return spectate\Field1
    Return $00
End Function
