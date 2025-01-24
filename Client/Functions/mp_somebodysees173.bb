Function mp_somebodysees173%(arg0.npcs)
    Local local0.mp_player
    If (chs\Field2 = $00) Then
        For local0 = Each mp_player
            If (entityhidden(local0\Field18) = $00) Then
                If (((2500.0 > entitydistancesquared(local0\Field18, arg0\Field3)) And (local0\Field29 = $00)) <> 0) Then
                    If ((entityinview(arg0\Field0, local0\Field19) Lor entityinview(arg0\Field1, local0\Field19)) <> 0) Then
                        Return $01
                    EndIf
                EndIf
            EndIf
        Next
    EndIf
    Return $00
    Return $00
End Function
