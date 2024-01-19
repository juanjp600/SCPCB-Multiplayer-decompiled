Function multiplayer_getplayerscount%()
    Local local0%
    Local local1%
    For local1 = $01 To networkserver\Field14 Step $01
        If (player[local1] <> Null) Then
            If (multiplayer_checktimeout(local1) = $00) Then
                local0 = (local0 + $01)
            EndIf
        EndIf
    Next
    Return local0
    Return $00
End Function
